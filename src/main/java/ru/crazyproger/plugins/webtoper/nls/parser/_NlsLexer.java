/*
 * Copyright 2012 Vladimir Rudev
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

/* The following code was generated by JFlex 1.4.3 on 22.11.12 20:46 */

package ru.crazyproger.plugins.webtoper.nls.parser;

import com.intellij.lang.properties.parsing.PropertiesTokenTypes;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;


/**
 * This class is a scanner generated by
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 22.11.12 20:46 from the specification file
 * <tt>/home/ice/projects/plugins/webtoper/src/main/java/ru/crazyproger/plugins/webtoper/nls/parser/Nls.flex</tt>
 */
class _NlsLexer implements FlexLexer {
    /**
     * initial size of the lookahead buffer
     */
    private static final int ZZ_BUFFERSIZE = 16384;

    /**
     * lexical states
     */
    public static final int IN_INCLUDE_START_LIST = 8;
    public static final int IN_INCLUDE_LIST = 10;
    public static final int YYINITIAL = 0;
    public static final int IN_VALUE = 2;
    public static final int IN_INCLUDE_VALUE_SEPARATOR = 6;
    public static final int IN_KEY_VALUE_SEPARATOR = 4;

    /**
     * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
     * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
     * at the beginning of a line
     * l is of the form l = 2*k, k a non negative integer
     */
    private static final int ZZ_LEXSTATE[] = {
            0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5
    };

    /**
     * Translates characters to character classes
     */
    private static final String ZZ_CMAP_PACKED =
            "\11\0\1\3\1\1\1\0\1\5\1\2\22\0\1\11\1\6\1\0" +
                    "\1\6\10\0\1\10\15\0\1\7\2\0\1\7\5\0\1\17\1\21" +
                    "\1\22\3\0\1\16\2\0\1\13\1\0\1\12\4\0\1\14\1\0" +
                    "\1\20\6\0\1\4\2\0\1\15\uffa0\0";

    /**
     * Translates characters to character classes
     */
    private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

    /**
     * Translates DFA states to action switch labels.
     */
    private static final int[] ZZ_ACTION = zzUnpackAction();

    private static final String ZZ_ACTION_PACKED_0 =
            "\6\0\1\1\1\2\1\3\1\4\1\3\1\1\1\5" +
                    "\1\6\1\5\1\3\2\7\2\10\2\11\1\2\1\12" +
                    "\1\0\1\1\2\4\1\1\1\0\1\5\11\1\1\13";

    private static int[] zzUnpackAction() {
        int[] result = new int[41];
        int offset = 0;
        offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAction(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }


    /**
     * Translates a state to a row index in the transition table
     */
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();

    private static final String ZZ_ROWMAP_PACKED_0 =
            "\0\0\0\23\0\46\0\71\0\114\0\137\0\162\0\205" +
                    "\0\230\0\253\0\276\0\321\0\344\0\367\0\u010a\0\u011d" +
                    "\0\u0130\0\u0143\0\u0156\0\u0169\0\u017c\0\u018f\0\u01a2\0\276" +
                    "\0\230\0\u01b5\0\u01c8\0\u01db\0\u01ee\0\u011d\0\u0201\0\u0214" +
                    "\0\u0227\0\u023a\0\u024d\0\u0260\0\u0273\0\u0286\0\u0299\0\u02ac" +
                    "\0\162";

    private static int[] zzUnpackRowMap() {
        int[] result = new int[41];
        int offset = 0;
        offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackRowMap(String packed, int offset, int[] result) {
        int i = 0;  /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int high = packed.charAt(i++) << 16;
            result[j++] = high | packed.charAt(i++);
        }
        return j;
    }

    /**
     * The transition table of the DFA
     */
    private static final int[] ZZ_TRANS = zzUnpackTrans();

    private static final String ZZ_TRANS_PACKED_0 =
            "\1\7\3\10\1\11\1\10\1\12\1\13\1\7\1\10" +
                    "\1\14\10\7\1\15\2\16\1\17\1\20\1\10\3\15" +
                    "\1\17\11\15\1\13\2\16\1\21\1\13\1\10\1\13" +
                    "\1\22\1\13\1\21\12\13\2\10\1\23\1\13\1\10" +
                    "\1\13\1\24\1\13\1\23\11\13\1\25\2\10\1\26" +
                    "\1\13\1\10\2\25\1\13\1\10\11\25\1\13\2\16" +
                    "\1\27\1\13\1\10\2\13\1\30\1\27\11\13\1\7" +
                    "\3\0\1\31\1\0\1\7\1\0\1\7\1\0\11\7" +
                    "\1\0\3\10\1\0\1\10\3\0\1\10\11\0\2\7" +
                    "\1\32\20\7\1\12\2\0\1\33\1\34\1\33\1\12" +
                    "\1\33\1\12\1\33\11\12\23\0\1\7\3\0\1\31" +
                    "\1\0\1\7\1\0\1\7\1\0\1\7\1\35\7\7" +
                    "\1\15\2\0\1\15\1\36\1\0\15\15\1\0\3\16" +
                    "\1\0\1\16\3\0\1\16\11\0\1\15\2\10\1\17" +
                    "\1\36\1\10\3\15\1\17\13\15\1\37\20\15\1\0" +
                    "\2\10\1\21\1\0\1\10\1\0\1\22\1\0\1\21" +
                    "\14\0\1\22\5\0\1\22\12\0\2\10\1\23\1\0" +
                    "\1\10\1\0\1\24\1\0\1\23\14\0\1\24\5\0" +
                    "\1\24\11\0\1\25\2\0\1\25\2\0\2\25\2\0" +
                    "\12\25\2\10\1\26\1\0\1\10\2\25\1\0\1\10" +
                    "\11\25\1\0\2\10\1\27\1\0\1\10\2\0\1\30" +
                    "\1\27\11\0\2\7\2\0\1\31\1\0\1\7\1\0" +
                    "\1\7\1\0\11\7\1\33\2\0\20\33\1\12\1\7" +
                    "\1\32\20\12\1\7\3\0\1\31\1\0\1\7\1\0" +
                    "\1\7\1\0\2\7\1\40\6\7\2\15\1\0\1\15" +
                    "\1\36\1\0\15\15\1\7\3\0\1\31\1\0\1\7" +
                    "\1\0\1\7\1\0\3\7\1\41\6\7\3\0\1\31" +
                    "\1\0\1\7\1\0\1\7\1\0\4\7\1\42\5\7" +
                    "\3\0\1\31\1\0\1\7\1\0\1\7\1\0\1\43" +
                    "\11\7\3\0\1\31\1\0\1\7\1\0\1\7\1\0" +
                    "\5\7\1\44\4\7\3\0\1\31\1\0\1\7\1\0" +
                    "\1\7\1\0\1\7\1\45\10\7\3\0\1\31\1\0" +
                    "\1\7\1\0\1\7\1\0\6\7\1\46\3\7\3\0" +
                    "\1\31\1\0\1\7\1\0\1\7\1\0\7\7\1\47" +
                    "\2\7\3\0\1\31\1\0\1\7\1\0\1\7\1\0" +
                    "\10\7\1\50\1\7\3\0\1\31\1\0\1\7\1\0" +
                    "\1\7\1\0\2\7\1\51\6\7";

    private static int[] zzUnpackTrans() {
        int[] result = new int[703];
        int offset = 0;
        offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackTrans(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            value--;
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }


    /* error codes */
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    private static final char[] EMPTY_BUFFER = new char[0];
    private static final int YYEOF = -1;
    private static java.io.Reader zzReader = null; // Fake

    /* error messages for the codes above */
    private static final String ZZ_ERROR_MSG[] = {
            "Unkown internal scanner error",
            "Error: could not match input",
            "Error: pushback value was too large"
    };

    /**
     * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
     */
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();

    private static final String ZZ_ATTRIBUTE_PACKED_0 =
            "\6\0\4\1\1\11\14\1\1\11\1\0\4\1\1\0" +
                    "\13\1";

    private static int[] zzUnpackAttribute() {
        int[] result = new int[41];
        int offset = 0;
        offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAttribute(String packed, int offset, int[] result) {
        int i = 0;       /* index in packed string  */
        int j = offset;  /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do result[j++] = value; while (--count > 0);
        }
        return j;
    }

    /**
     * the current state of the DFA
     */
    private int zzState;

    /**
     * the current lexical state
     */
    private int zzLexicalState = YYINITIAL;

    /**
     * this buffer contains the current text to be matched and is
     * the source of the yytext() string
     */
    private CharSequence zzBuffer = "";

    /**
     * this buffer may contains the current text array to be matched when it is cheap to acquire it
     */
    private char[] zzBufferArray;

    /**
     * the textposition at the last accepting state
     */
    private int zzMarkedPos;

    /**
     * the textposition at the last state to be included in yytext
     */
    private int zzPushbackPos;

    /**
     * the current text position in the buffer
     */
    private int zzCurrentPos;

    /**
     * startRead marks the beginning of the yytext() string in the buffer
     */
    private int zzStartRead;

    /**
     * endRead marks the last character in the buffer, that has been read
     * from input
     */
    private int zzEndRead;

    /**
     * zzAtBOL == true <=> the scanner is currently at the beginning of a line
     */
    private boolean zzAtBOL = true;

    /**
     * zzAtEOF == true <=> the scanner is at the EOF
     */
    private boolean zzAtEOF;

    /**
     * denotes if the user-EOF-code has already been executed
     */
    private boolean zzEOFDone;


    _NlsLexer(java.io.Reader in) {
        this.zzReader = in;
    }

    /**
     * Creates a new scanner.
     * There is also java.io.Reader version of this constructor.
     *
     * @param in the java.io.Inputstream to read input from.
     */
    _NlsLexer(java.io.InputStream in) {
        this(new java.io.InputStreamReader(in));
    }

    /**
     * Unpacks the compressed character translation table.
     *
     * @param packed the packed character translation table
     * @return the unpacked character translation table
     */
    private static char[] zzUnpackCMap(String packed) {
        char[] map = new char[0x10000];
        int i = 0;  /* index in packed string  */
        int j = 0;  /* index in unpacked array */
        while (i < 72) {
            int count = packed.charAt(i++);
            char value = packed.charAt(i++);
            do map[j++] = value; while (--count > 0);
        }
        return map;
    }

    public final int getTokenStart() {
        return zzStartRead;
    }

    public final int getTokenEnd() {
        return getTokenStart() + yylength();
    }

    public void reset(CharSequence buffer, int start, int end, int initialState) {
        zzBuffer = buffer;
        zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
        zzCurrentPos = zzMarkedPos = zzStartRead = start;
        zzPushbackPos = 0;
        zzAtEOF = false;
        zzAtBOL = true;
        zzEndRead = end;
        yybegin(initialState);
    }

    /**
     * Refills the input buffer.
     *
     * @return <code>false</code>, iff there was new input.
     * @throws java.io.IOException if any I/O-Error occurs
     */
    private boolean zzRefill() throws java.io.IOException {
        return true;
    }


    /**
     * Returns the current lexical state.
     */
    public final int yystate() {
        return zzLexicalState;
    }


    /**
     * Enters a new lexical state
     *
     * @param newState the new lexical state
     */
    public final void yybegin(int newState) {
        zzLexicalState = newState;
    }


    /**
     * Returns the text matched by the current regular expression.
     */
    public final CharSequence yytext() {
        return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
    }


    /**
     * Returns the character at position <tt>pos</tt> from the
     * matched text.
     * <p/>
     * It is equivalent to yytext().charAt(pos), but faster
     *
     * @param pos the position of the character to fetch.
     *            A value from 0 to yylength()-1.
     * @return the character at position pos
     */
    public final char yycharat(int pos) {
        return zzBufferArray != null ? zzBufferArray[zzStartRead + pos] : zzBuffer.charAt(zzStartRead + pos);
    }


    /**
     * Returns the length of the matched text region.
     */
    public final int yylength() {
        return zzMarkedPos - zzStartRead;
    }


    /**
     * Reports an error that occured while scanning.
     * <p/>
     * In a wellformed scanner (no or only correct usage of
     * yypushback(int) and a match-all fallback rule) this method
     * will only be called with things that "Can't Possibly Happen".
     * If this method is called, something is seriously wrong
     * (e.g. a JFlex bug producing a faulty scanner etc.).
     * <p/>
     * Usual syntax/scanner level error handling should be done
     * in error fallback rules.
     *
     * @param errorCode the code of the errormessage to display
     */
    private void zzScanError(int errorCode) {
        String message;
        try {
            message = ZZ_ERROR_MSG[errorCode];
        } catch (ArrayIndexOutOfBoundsException e) {
            message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
        }

        throw new Error(message);
    }


    /**
     * Pushes the specified amount of characters back into the input stream.
     * <p/>
     * They will be read again by then next call of the scanning method
     *
     * @param number the number of characters to be read again.
     *               This number must not be greater than yylength()!
     */
    public void yypushback(int number) {
        if (number > yylength())
            zzScanError(ZZ_PUSHBACK_2BIG);

        zzMarkedPos -= number;
    }


    /**
     * Contains user EOF-code, which will be executed exactly once,
     * when the end of file is reached
     */
    private void zzDoEOF() {
        if (!zzEOFDone) {
            zzEOFDone = true;

        }
    }


    /**
     * Resumes scanning until the next regular expression is matched,
     * the end of input is encountered or an I/O-Error occurs.
     *
     * @return the next token
     * @throws java.io.IOException if any I/O-Error occurs
     */
    public IElementType advance() throws java.io.IOException {
        int zzInput;
        int zzAction;

        // cached fields:
        int zzCurrentPosL;
        int zzMarkedPosL;
        int zzEndReadL = zzEndRead;
        CharSequence zzBufferL = zzBuffer;
        char[] zzBufferArrayL = zzBufferArray;
        char[] zzCMapL = ZZ_CMAP;

        int[] zzTransL = ZZ_TRANS;
        int[] zzRowMapL = ZZ_ROWMAP;
        int[] zzAttrL = ZZ_ATTRIBUTE;

        while (true) {
            zzMarkedPosL = zzMarkedPos;

            zzAction = -1;

            zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

            zzState = ZZ_LEXSTATE[zzLexicalState];


            zzForAction:
            {
                while (true) {

                    if (zzCurrentPosL < zzEndReadL)
                        zzInput = zzBufferL.charAt(zzCurrentPosL++);
                    else if (zzAtEOF) {
                        zzInput = YYEOF;
                        break zzForAction;
                    } else {
                        // store back cached positions
                        zzCurrentPos = zzCurrentPosL;
                        zzMarkedPos = zzMarkedPosL;
                        boolean eof = zzRefill();
                        // get translated positions and possibly new buffer
                        zzCurrentPosL = zzCurrentPos;
                        zzMarkedPosL = zzMarkedPos;
                        zzBufferL = zzBuffer;
                        zzEndReadL = zzEndRead;
                        if (eof) {
                            zzInput = YYEOF;
                            break zzForAction;
                        } else {
                            zzInput = zzBufferL.charAt(zzCurrentPosL++);
                        }
                    }
                    int zzNext = zzTransL[zzRowMapL[zzState] + zzCMapL[zzInput]];
                    if (zzNext == -1) break zzForAction;
                    zzState = zzNext;

                    int zzAttributes = zzAttrL[zzState];
                    if ((zzAttributes & 1) == 1) {
                        zzAction = zzState;
                        zzMarkedPosL = zzCurrentPosL;
                        if ((zzAttributes & 8) == 8) break zzForAction;
                    }

                }
            }

            // store back cached position
            zzMarkedPos = zzMarkedPosL;

            switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
                case 11: {
                    yybegin(IN_INCLUDE_VALUE_SEPARATOR);
                    return NlsTokenTypes.INCLUDE_KEYWORD;
                }
                case 12:
                    break;
                case 6: {
                    yybegin(YYINITIAL);
                    return PropertiesTokenTypes.WHITE_SPACE;
                }
                case 13:
                    break;
                case 7: {
                    yybegin(IN_VALUE);
                    return PropertiesTokenTypes.KEY_VALUE_SEPARATOR;
                }
                case 14:
                    break;
                case 9: {
                    yybegin(IN_INCLUDE_LIST);
                    return NlsTokenTypes.NLS_NAME;
                }
                case 15:
                    break;
                case 8: {
                    yybegin(IN_INCLUDE_START_LIST);
                    return PropertiesTokenTypes.KEY_VALUE_SEPARATOR;
                }
                case 16:
                    break;
                case 2: {
                    return PropertiesTokenTypes.WHITE_SPACE;
                }
                case 17:
                    break;
                case 1: {
                    yybegin(IN_KEY_VALUE_SEPARATOR);
                    return PropertiesTokenTypes.KEY_CHARACTERS;
                }
                case 18:
                    break;
                case 5: {
                    yybegin(YYINITIAL);
                    return PropertiesTokenTypes.VALUE_CHARACTERS;
                }
                case 19:
                    break;
                case 3: {
                    return PropertiesTokenTypes.BAD_CHARACTER;
                }
                case 20:
                    break;
                case 4: {
                    yybegin(YYINITIAL);
                    return PropertiesTokenTypes.END_OF_LINE_COMMENT;
                }
                case 21:
                    break;
                case 10: {
                    yybegin(IN_INCLUDE_START_LIST);
                    return NlsTokenTypes.NLS_SEPARATOR;
                }
                case 22:
                    break;
                default:
                    if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
                        zzAtEOF = true;
                        zzDoEOF();
                        return null;
                    } else {
                        zzScanError(ZZ_NO_MATCH);
                    }
            }
        }
    }


}
