/*
 * Copyright 2013 Vladimir Rudev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.crazyproger.plugins.webtoper;

import com.intellij.facet.FacetManager;
import com.intellij.ide.highlighter.XmlFileType;
import com.intellij.javaee.web.WebRoot;
import com.intellij.javaee.web.facet.WebFacet;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.GlobalSearchScopes;
import com.intellij.util.FileContentUtil;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.crazyproger.plugins.webtoper.config.WebtoperFacet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Utils {
    public static void reparseFilesInRoots(Project project, Iterable<VirtualFile> roots, String extension) {
        List<VirtualFile> files = new LinkedList<VirtualFile>();
        for (VirtualFile file : roots) {
            collectFiles(project, extension, files, file);
        }
        FileContentUtil.reparseFiles(project, files, true);
    }

    private static void collectFiles(Project project, String extension, List<VirtualFile> files, VirtualFile root) {
        if (root.isDirectory()) {
            PsiDirectory directory = PsiManager.getInstance(project).findDirectory(root);
            if (directory != null) {
                GlobalSearchScope scope = GlobalSearchScopes.directoryScope(directory, true);
                files.addAll(FilenameIndex.getAllFilesByExt(project, extension, scope));
            }
        } else {
            files.add(root);
        }
    }

    public static void reparseFilesInRoot(Project project, VirtualFile nlsRoot, String defaultExtension) {
        LinkedList<VirtualFile> files = new LinkedList<VirtualFile>();
        collectFiles(project, defaultExtension, files, nlsRoot);
        FileContentUtil.reparseFiles(project, files, true);
    }

    // todo #WT-27
    @NotNull
    public static List<WebtoperFacet> getWebtoperFacets(Project project) {
        ModuleManager moduleManager = ModuleManager.getInstance(project);
        Module[] modules = moduleManager.getModules();
        List<WebtoperFacet> facets = new ArrayList<WebtoperFacet>(modules.length);
        for (Module module : modules) {
            Collection<WebtoperFacet> facetsByType = getWebtoperFacets(module);
            facets.addAll(facetsByType);
        }
        return facets;
    }

    public static Collection<WebtoperFacet> getWebtoperFacets(Module module) {
        FacetManager facetManager = FacetManager.getInstance(module);
        return facetManager.getFacetsByType(WebtoperFacet.ID);
    }

    /**
     * todo #WT-29
     * todo #WT-28
     */
    @Nullable
    public static VirtualFile findFileInArtifact(String configPath, Project project) {
        final List<WebtoperFacet> facets = getWebtoperFacets(project);
        final List<WebRoot> webRoots = getWebRoots(facets);
        return findConfig(configPath, webRoots);
    }

    @Nullable
    public static VirtualFile findConfig(String configPath, List<WebRoot> webRoots) {
        for (WebRoot webRoot : webRoots) {
            boolean isStartsWith = StringUtils.startsWith("/" + configPath, webRoot.getRelativePath());
            if (isStartsWith) {
                final VirtualFile file = webRoot.getFile();
                if (file != null) {
                    final VirtualFile result = file.findFileByRelativePath(configPath);
                    if (result != null) {
                        return result;
                    }

                }
            }
        }
        return null;
    }

    public static List<WebRoot> getWebRoots(List<WebtoperFacet> facets) {
        List<WebRoot> webRoots = new ArrayList<WebRoot>();
        for (WebtoperFacet facet : facets) {
            WebFacet webFacet = (WebFacet) facet.getUnderlyingFacet();
            webRoots.addAll(webFacet.getWebRoots());
        }
        return webRoots;
    }

    @Nullable
    public static String findPathInArtifact(VirtualFile file, Module module) {
        final List<WebtoperFacet> facets = getWebtoperFacets(module.getProject());
        final List<WebRoot> webRoots = getWebRoots(facets);
        for (WebRoot webRoot : webRoots) {
            VirtualFile webRootFolder = webRoot.getFile();
            assert webRootFolder != null;
            if (VfsUtil.isAncestor(webRootFolder, file, false)) {
                return VfsUtil.getRelativePath(file, webRootFolder, '/');
            }
        }
        return null;
    }

    @NotNull
    public static GlobalSearchScope getWebRootsScope(Module module) {
        Project project = module.getProject();
        final List<WebtoperFacet> facets = getWebtoperFacets(project);
        final List<WebRoot> webRoots = getWebRoots(facets);
        if (webRoots.isEmpty()) {
            return GlobalSearchScope.EMPTY_SCOPE;
        }
        GlobalSearchScope scope = null;
        for (WebRoot webRoot : webRoots) {
            VirtualFile file = webRoot.getFile();
            if (file != null) {
                GlobalSearchScope searchScope = GlobalSearchScopes.directoryScope(project, file, true);
                scope = (scope == null) ? searchScope : scope.union(searchScope);
            }

        }
        assert scope != null;
        return scope;
    }

    @NotNull
    public static GlobalSearchScope getXmlConfigsScope(Module module) {
        GlobalSearchScope rootsScope = Utils.getWebRootsScope(module);
        return GlobalSearchScope.getScopeRestrictedByFileTypes(rootsScope, XmlFileType.INSTANCE);
    }
}
