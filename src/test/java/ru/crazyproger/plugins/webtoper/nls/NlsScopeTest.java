package ru.crazyproger.plugins.webtoper.nls;

import com.intellij.facet.FacetManager;
import com.intellij.facet.ModifiableFacetModel;
import com.intellij.javaee.web.facet.WebFacet;
import com.intellij.javaee.web.facet.WebFacetType;
import com.intellij.lang.properties.PropertiesFileType;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.testFramework.TestSourceBasedTestCase;
import ru.crazyproger.plugins.webtoper.WebtoperTestHelper;
import ru.crazyproger.plugins.webtoper.config.WebtoperFacet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Simple test that check configuration of NLS folders and {@link NlsUtils#getNlsScope(com.intellij.openapi.project.Project)} method.
 * <p/>
 *
 * @author crazyproger
 */
public class NlsScopeTest extends TestSourceBasedTestCase {

    @Override
    protected String getTestPath() {
        return WebtoperTestHelper.TEST_DATA_PATH;
    }

    protected String getTestDataPath() {
        return WebtoperTestHelper.getRootPath();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        String moduleRootPath = ModuleRootManager.getInstance(getModule()).getContentRoots()[0].getPath();
        FacetManager facetManager = FacetManager.getInstance(myModule);
        WebFacet container = facetManager.createFacet(WebFacetType.getInstance(), "Web", null);
        WebtoperFacet facet = facetManager.createFacet(WebtoperFacet.getFacetType(), "Webtoper", container);
        List<VirtualFile> nlsRoots = new ArrayList<VirtualFile>();
        findAndAdd(moduleRootPath + "/layer1", nlsRoots);
        findAndAdd(moduleRootPath + "/layer2", nlsRoots);
        findAndAdd(moduleRootPath + "/layer3", nlsRoots);

        facet.getConfiguration().setNlsRoots(nlsRoots);
        final ModifiableFacetModel facetModel = facetManager.createModifiableModel();
        facetModel.addFacet(facet);
        ApplicationManager.getApplication().runWriteAction(new Runnable() {
            @Override
            public void run() {
                facetModel.commit();
            }
        });
    }

    private void findAndAdd(String filePath, List<VirtualFile> nlsRoots) {
        VirtualFile file = LocalFileSystem.getInstance().findFileByPath(filePath);
        if (file != null) {
            nlsRoots.add(file);
        }
    }

    public void testNlsFilesScope() throws Throwable {
        GlobalSearchScope nlsScope = NlsUtils.getNlsScope(getProject());
        assertNotNull(nlsScope);
        Collection<VirtualFile> files = FileTypeIndex.getFiles(PropertiesFileType.INSTANCE, nlsScope);
        assertNotNull(files);
        assertEquals(3, files.size());
    }

    public void testNlsFullName() throws Throwable {
        GlobalSearchScope nlsScope = NlsUtils.getNlsScope(getProject());
        Collection<VirtualFile> files = FileTypeIndex.getFiles(PropertiesFileType.INSTANCE, nlsScope);
        VirtualFile file = files.iterator().next();
        String fullName = NlsUtils.getNlsName(file, getProject());
        assertEquals("ru.crazyproger.l1.document.Document", fullName);
    }

}
