// Generated from /Users/phay/IdeaProjects/vanilla-b521-lang/src/org/yahw/B521Lang.g4 by ANTLR 4.7
package org.yahw;



import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class B521LangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, INT=4, BOOLEAN=5, STRING=6, SYMBOL=7, COMMENT=8, 
		WS=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "INT", "BOOLEAN", "STRING", "SYMBOL", "COMMENT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "INT", "BOOLEAN", "STRING", "SYMBOL", "COMMENT", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public B521LangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "B521Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13O\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\6\5\35\n\5\r\5\16\5\36\3\6\3\6\3\6\3\6\5\6%\n\6\3"+
		"\7\3\7\3\7\3\7\7\7+\n\7\f\7\16\7.\13\7\3\7\3\7\3\b\6\b\63\n\b\r\b\16\b"+
		"\64\3\b\7\b8\n\b\f\b\16\b;\13\b\3\b\7\b>\n\b\f\b\16\bA\13\b\3\t\3\t\7"+
		"\tE\n\t\f\t\16\tH\13\t\3\t\3\t\3\n\3\n\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\3\2\7\3\2\62;\3\2$$\7\2--//>@C\\c|\4\2\f\f\17"+
		"\17\5\2\13\f\17\17\"\"\2V\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3"+
		"\25\3\2\2\2\5\27\3\2\2\2\7\31\3\2\2\2\t\34\3\2\2\2\13$\3\2\2\2\r&\3\2"+
		"\2\2\17\62\3\2\2\2\21B\3\2\2\2\23K\3\2\2\2\25\26\7*\2\2\26\4\3\2\2\2\27"+
		"\30\7+\2\2\30\6\3\2\2\2\31\32\7)\2\2\32\b\3\2\2\2\33\35\t\2\2\2\34\33"+
		"\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\n\3\2\2\2 !\7%\2"+
		"\2!%\7h\2\2\"#\7%\2\2#%\7v\2\2$ \3\2\2\2$\"\3\2\2\2%\f\3\2\2\2&,\7$\2"+
		"\2\'+\n\3\2\2()\7^\2\2)+\7$\2\2*\'\3\2\2\2*(\3\2\2\2+.\3\2\2\2,*\3\2\2"+
		"\2,-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\7$\2\2\60\16\3\2\2\2\61\63\t\4\2"+
		"\2\62\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\659\3\2\2\2"+
		"\668\t\2\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:?\3\2\2\2;"+
		"9\3\2\2\2<>\7A\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\20\3\2\2\2"+
		"A?\3\2\2\2BF\7=\2\2CE\n\5\2\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2"+
		"GI\3\2\2\2HF\3\2\2\2IJ\b\t\2\2J\22\3\2\2\2KL\t\6\2\2LM\3\2\2\2MN\b\n\2"+
		"\2N\24\3\2\2\2\13\2\36$*,\649?F\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}