/* A Bison parser, made by GNU Bison 2.7.  */

/* Bison implementation for Yacc-like parsers in C
   
      Copyright (C) 1984, 1989-1990, 2000-2012 Free Software Foundation, Inc.
   
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.
   
   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* C LALR(1) parser skeleton written by Richard Stallman, by
   simplifying the original so-called "semantic" parser.  */

/* All symbols defined below should begin with yy or YY, to avoid
   infringing on user name space.  This should be done even for local
   variables, as they might otherwise be expanded by user macros.
   There are some unavoidable exceptions within include files to
   define necessary library symbols; they are noted "INFRINGES ON
   USER NAME SPACE" below.  */

/* Identify Bison output.  */
#define YYBISON 1

/* Bison version.  */
#define YYBISON_VERSION "2.7"

/* Skeleton name.  */
#define YYSKELETON_NAME "yacc.c"

/* Pure parsers.  */
#define YYPURE 0

/* Push parsers.  */
#define YYPUSH 0

/* Pull parsers.  */
#define YYPULL 1




/* Copy the first part of user declarations.  */
/* Line 371 of yacc.c  */
#line 11 "lab9.y"

/* begin specs */
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
//#include "lex.yy.c"
#include "symtable.h"
#include "ast.h"
int yylex();

extern int count; 
 int level=0; 
 int goff;
 int off; 
  int maxoffset;

void yyerror (s)  /* Called by yyparse on error */
     char *s;
{
  printf ("%s on line:%d \n", s, count);
}



/* Line 371 of yacc.c  */
#line 93 "y.tab.c"

# ifndef YY_NULL
#  if defined __cplusplus && 201103L <= __cplusplus
#   define YY_NULL nullptr
#  else
#   define YY_NULL 0
#  endif
# endif

/* Enabling verbose error messages.  */
#ifdef YYERROR_VERBOSE
# undef YYERROR_VERBOSE
# define YYERROR_VERBOSE 1
#else
# define YYERROR_VERBOSE 0
#endif

/* In a future release of Bison, this section will be replaced
   by #include "y.tab.h".  */
#ifndef YY_YY_Y_TAB_H_INCLUDED
# define YY_YY_Y_TAB_H_INCLUDED
/* Enabling traces.  */
#ifndef YYDEBUG
# define YYDEBUG 0
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Tokens.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
   /* Put the tokens into the symbol table, so that GDB and other debuggers
      know about them.  */
   enum yytokentype {
     ID = 258,
     STRING = 259,
     NUM = 260,
     INT = 261,
     VOID = 262,
     IF = 263,
     ELSE = 264,
     WHILE = 265,
     FOR = 266,
     RETURN = 267,
     READ = 268,
     WRITE = 269,
     LE = 270,
     L = 271,
     GE = 272,
     G = 273,
     EQ = 274,
     NE = 275
   };
#endif
/* Tokens.  */
#define ID 258
#define STRING 259
#define NUM 260
#define INT 261
#define VOID 262
#define IF 263
#define ELSE 264
#define WHILE 265
#define FOR 266
#define RETURN 267
#define READ 268
#define WRITE 269
#define LE 270
#define L 271
#define GE 272
#define G 273
#define EQ 274
#define NE 275



#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef union YYSTYPE
{
/* Line 387 of yacc.c  */
#line 38 "lab9.y"

	int value; 
	char *string;
	ASTnode * node;  /* so we can build an AST */
      	enum OPERATORS operator; 


/* Line 387 of yacc.c  */
#line 184 "y.tab.c"
} YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define yystype YYSTYPE /* obsolescent; will be withdrawn */
# define YYSTYPE_IS_DECLARED 1
#endif

extern YYSTYPE yylval;

#ifdef YYPARSE_PARAM
#if defined __STDC__ || defined __cplusplus
int yyparse (void *YYPARSE_PARAM);
#else
int yyparse ();
#endif
#else /* ! YYPARSE_PARAM */
#if defined __STDC__ || defined __cplusplus
int yyparse (void);
#else
int yyparse ();
#endif
#endif /* ! YYPARSE_PARAM */

#endif /* !YY_YY_Y_TAB_H_INCLUDED  */

/* Copy the second part of user declarations.  */

/* Line 390 of yacc.c  */
#line 212 "y.tab.c"

#ifdef short
# undef short
#endif

#ifdef YYTYPE_UINT8
typedef YYTYPE_UINT8 yytype_uint8;
#else
typedef unsigned char yytype_uint8;
#endif

#ifdef YYTYPE_INT8
typedef YYTYPE_INT8 yytype_int8;
#elif (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
typedef signed char yytype_int8;
#else
typedef short int yytype_int8;
#endif

#ifdef YYTYPE_UINT16
typedef YYTYPE_UINT16 yytype_uint16;
#else
typedef unsigned short int yytype_uint16;
#endif

#ifdef YYTYPE_INT16
typedef YYTYPE_INT16 yytype_int16;
#else
typedef short int yytype_int16;
#endif

#ifndef YYSIZE_T
# ifdef __SIZE_TYPE__
#  define YYSIZE_T __SIZE_TYPE__
# elif defined size_t
#  define YYSIZE_T size_t
# elif ! defined YYSIZE_T && (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
#  include <stddef.h> /* INFRINGES ON USER NAME SPACE */
#  define YYSIZE_T size_t
# else
#  define YYSIZE_T unsigned int
# endif
#endif

#define YYSIZE_MAXIMUM ((YYSIZE_T) -1)

#ifndef YY_
# if defined YYENABLE_NLS && YYENABLE_NLS
#  if ENABLE_NLS
#   include <libintl.h> /* INFRINGES ON USER NAME SPACE */
#   define YY_(Msgid) dgettext ("bison-runtime", Msgid)
#  endif
# endif
# ifndef YY_
#  define YY_(Msgid) Msgid
# endif
#endif

/* Suppress unused-variable warnings by "using" E.  */
#if ! defined lint || defined __GNUC__
# define YYUSE(E) ((void) (E))
#else
# define YYUSE(E) /* empty */
#endif

/* Identity function, used to suppress warnings about constant conditions.  */
#ifndef lint
# define YYID(N) (N)
#else
#if (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
static int
YYID (int yyi)
#else
static int
YYID (yyi)
    int yyi;
#endif
{
  return yyi;
}
#endif

#if ! defined yyoverflow || YYERROR_VERBOSE

/* The parser invokes alloca or malloc; define the necessary symbols.  */

# ifdef YYSTACK_USE_ALLOCA
#  if YYSTACK_USE_ALLOCA
#   ifdef __GNUC__
#    define YYSTACK_ALLOC __builtin_alloca
#   elif defined __BUILTIN_VA_ARG_INCR
#    include <alloca.h> /* INFRINGES ON USER NAME SPACE */
#   elif defined _AIX
#    define YYSTACK_ALLOC __alloca
#   elif defined _MSC_VER
#    include <malloc.h> /* INFRINGES ON USER NAME SPACE */
#    define alloca _alloca
#   else
#    define YYSTACK_ALLOC alloca
#    if ! defined _ALLOCA_H && ! defined EXIT_SUCCESS && (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
#     include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
      /* Use EXIT_SUCCESS as a witness for stdlib.h.  */
#     ifndef EXIT_SUCCESS
#      define EXIT_SUCCESS 0
#     endif
#    endif
#   endif
#  endif
# endif

# ifdef YYSTACK_ALLOC
   /* Pacify GCC's `empty if-body' warning.  */
#  define YYSTACK_FREE(Ptr) do { /* empty */; } while (YYID (0))
#  ifndef YYSTACK_ALLOC_MAXIMUM
    /* The OS might guarantee only one guard page at the bottom of the stack,
       and a page size can be as small as 4096 bytes.  So we cannot safely
       invoke alloca (N) if N exceeds 4096.  Use a slightly smaller number
       to allow for a few compiler-allocated temporary stack slots.  */
#   define YYSTACK_ALLOC_MAXIMUM 4032 /* reasonable circa 2006 */
#  endif
# else
#  define YYSTACK_ALLOC YYMALLOC
#  define YYSTACK_FREE YYFREE
#  ifndef YYSTACK_ALLOC_MAXIMUM
#   define YYSTACK_ALLOC_MAXIMUM YYSIZE_MAXIMUM
#  endif
#  if (defined __cplusplus && ! defined EXIT_SUCCESS \
       && ! ((defined YYMALLOC || defined malloc) \
	     && (defined YYFREE || defined free)))
#   include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
#   ifndef EXIT_SUCCESS
#    define EXIT_SUCCESS 0
#   endif
#  endif
#  ifndef YYMALLOC
#   define YYMALLOC malloc
#   if ! defined malloc && ! defined EXIT_SUCCESS && (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
void *malloc (YYSIZE_T); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
#  ifndef YYFREE
#   define YYFREE free
#   if ! defined free && ! defined EXIT_SUCCESS && (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
void free (void *); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
# endif
#endif /* ! defined yyoverflow || YYERROR_VERBOSE */


#if (! defined yyoverflow \
     && (! defined __cplusplus \
	 || (defined YYSTYPE_IS_TRIVIAL && YYSTYPE_IS_TRIVIAL)))

/* A type that is properly aligned for any stack member.  */
union yyalloc
{
  yytype_int16 yyss_alloc;
  YYSTYPE yyvs_alloc;
};

/* The size of the maximum gap between one aligned stack and the next.  */
# define YYSTACK_GAP_MAXIMUM (sizeof (union yyalloc) - 1)

/* The size of an array large to enough to hold all stacks, each with
   N elements.  */
# define YYSTACK_BYTES(N) \
     ((N) * (sizeof (yytype_int16) + sizeof (YYSTYPE)) \
      + YYSTACK_GAP_MAXIMUM)

# define YYCOPY_NEEDED 1

/* Relocate STACK from its old location to the new one.  The
   local variables YYSIZE and YYSTACKSIZE give the old and new number of
   elements in the stack, and YYPTR gives the new location of the
   stack.  Advance YYPTR to a properly aligned location for the next
   stack.  */
# define YYSTACK_RELOCATE(Stack_alloc, Stack)				\
    do									\
      {									\
	YYSIZE_T yynewbytes;						\
	YYCOPY (&yyptr->Stack_alloc, Stack, yysize);			\
	Stack = &yyptr->Stack_alloc;					\
	yynewbytes = yystacksize * sizeof (*Stack) + YYSTACK_GAP_MAXIMUM; \
	yyptr += yynewbytes / sizeof (*yyptr);				\
      }									\
    while (YYID (0))

#endif

#if defined YYCOPY_NEEDED && YYCOPY_NEEDED
/* Copy COUNT objects from SRC to DST.  The source and destination do
   not overlap.  */
# ifndef YYCOPY
#  if defined __GNUC__ && 1 < __GNUC__
#   define YYCOPY(Dst, Src, Count) \
      __builtin_memcpy (Dst, Src, (Count) * sizeof (*(Src)))
#  else
#   define YYCOPY(Dst, Src, Count)              \
      do                                        \
        {                                       \
          YYSIZE_T yyi;                         \
          for (yyi = 0; yyi < (Count); yyi++)   \
            (Dst)[yyi] = (Src)[yyi];            \
        }                                       \
      while (YYID (0))
#  endif
# endif
#endif /* !YYCOPY_NEEDED */

/* YYFINAL -- State number of the termination state.  */
#define YYFINAL  9
/* YYLAST -- Last index in YYTABLE.  */
#define YYLAST   110

/* YYNTOKENS -- Number of terminals.  */
#define YYNTOKENS  34
/* YYNNTS -- Number of nonterminals.  */
#define YYNNTS  36
/* YYNRULES -- Number of rules.  */
#define YYNRULES  72
/* YYNRULES -- Number of states.  */
#define YYNSTATES  119

/* YYTRANSLATE(YYLEX) -- Bison symbol number corresponding to YYLEX.  */
#define YYUNDEFTOK  2
#define YYMAXUTOK   275

#define YYTRANSLATE(YYX)						\
  ((unsigned int) (YYX) <= YYMAXUTOK ? yytranslate[YYX] : YYUNDEFTOK)

/* YYTRANSLATE[YYLEX] -- Bison symbol number corresponding to YYLEX.  */
static const yytype_uint8 yytranslate[] =
{
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
      24,    25,    32,    30,    26,    31,     2,    33,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,    21,
       2,    29,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,    22,     2,    23,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    27,     2,    28,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20
};

#if YYDEBUG
/* YYPRHS[YYN] -- Index of the first RHS symbol of rule number YYN in
   YYRHS.  */
static const yytype_uint8 yyprhs[] =
{
       0,     0,     3,     5,     7,    10,    12,    14,    18,    25,
      27,    29,    30,    31,    40,    42,    44,    46,    50,    53,
      58,    59,    65,    66,    69,    70,    73,    75,    77,    79,
      81,    83,    85,    87,    89,    92,    94,    98,   104,   112,
     118,   121,   125,   129,   133,   137,   139,   141,   146,   148,
     152,   154,   156,   158,   160,   162,   164,   166,   170,   172,
     174,   176,   180,   182,   184,   188,   190,   192,   194,   199,
     201,   202,   204
};

/* YYRHS -- A `-1'-separated list of the rules' RHS.  */
static const yytype_int8 yyrhs[] =
{
      35,     0,    -1,    36,    -1,    37,    -1,    37,    36,    -1,
      38,    -1,    40,    -1,    39,     3,    21,    -1,    39,     3,
      22,     5,    23,    21,    -1,     6,    -1,     7,    -1,    -1,
      -1,    39,     3,    24,    41,    43,    42,    25,    46,    -1,
       7,    -1,    44,    -1,    45,    -1,    45,    26,    44,    -1,
      39,     3,    -1,    39,     3,    22,    23,    -1,    -1,    27,
      47,    48,    49,    28,    -1,    -1,    38,    48,    -1,    -1,
      50,    49,    -1,    51,    -1,    46,    -1,    53,    -1,    54,
      -1,    52,    -1,    55,    -1,    56,    -1,    57,    -1,    58,
      21,    -1,    21,    -1,    59,    29,    51,    -1,     8,    24,
      58,    25,    50,    -1,     8,    24,    58,    25,    50,     9,
      50,    -1,    10,    24,    58,    25,    50,    -1,    12,    21,
      -1,    12,    58,    21,    -1,    13,    59,    21,    -1,    14,
      58,    21,    -1,    14,     4,    21,    -1,    60,    -1,     3,
      -1,     3,    22,    58,    23,    -1,    62,    -1,    60,    61,
      62,    -1,    15,    -1,    16,    -1,    18,    -1,    17,    -1,
      19,    -1,    20,    -1,    64,    -1,    62,    63,    64,    -1,
      30,    -1,    31,    -1,    66,    -1,    64,    65,    66,    -1,
      32,    -1,    33,    -1,    24,    58,    25,    -1,     5,    -1,
      59,    -1,    67,    -1,     3,    24,    68,    25,    -1,    69,
      -1,    -1,    58,    -1,    58,    26,    69,    -1
};

/* YYRLINE[YYN] -- source line where rule number YYN was defined.  */
static const yytype_uint16 yyrline[] =
{
       0,    55,    55,    59,    60,    66,    67,    70,    86,   106,
     107,   110,   123,   110,   147,   148,   151,   152,   157,   176,
     194,   194,   210,   211,   219,   220,   223,   224,   225,   226,
     227,   228,   229,   230,   233,   242,   245,   260,   265,   272,
     279,   280,   288,   296,   299,   305,   311,   333,   361,   362,
     380,   381,   382,   383,   384,   385,   388,   389,   409,   410,
     413,   414,   433,   434,   437,   438,   442,   443,   446,   481,
     482,   485,   493
};
#endif

#if YYDEBUG || YYERROR_VERBOSE || 0
/* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
   First, the terminals, then, starting at YYNTOKENS, nonterminals.  */
static const char *const yytname[] =
{
  "$end", "error", "$undefined", "ID", "STRING", "NUM", "INT", "VOID",
  "IF", "ELSE", "WHILE", "FOR", "RETURN", "READ", "WRITE", "LE", "L", "GE",
  "G", "EQ", "NE", "';'", "'['", "']'", "'('", "')'", "','", "'{'", "'}'",
  "'='", "'+'", "'-'", "'*'", "'/'", "$accept", "program", "DL", "DEC",
  "VARDEC", "typespec", "FUNDEC", "$@1", "$@2", "params", "paramlist",
  "param", "compoundstmt", "$@3", "localdec", "statementlist", "statement",
  "exprstmt", "assistmt", "selectstmt", "iterstmt", "returnstmt",
  "readstmt", "writestmt", "expression", "var", "simpleexpr", "relop",
  "additiveexpr", "addop", "term", "multop", "factor", "call", "args",
  "arglist", YY_NULL
};
#endif

# ifdef YYPRINT
/* YYTOKNUM[YYLEX-NUM] -- Internal token number corresponding to
   token YYLEX-NUM.  */
static const yytype_uint16 yytoknum[] =
{
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,    59,    91,    93,    40,    41,    44,   123,   125,    61,
      43,    45,    42,    47
};
# endif

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
static const yytype_uint8 yyr1[] =
{
       0,    34,    35,    36,    36,    37,    37,    38,    38,    39,
      39,    41,    42,    40,    43,    43,    44,    44,    45,    45,
      47,    46,    48,    48,    49,    49,    50,    50,    50,    50,
      50,    50,    50,    50,    51,    51,    52,    53,    53,    54,
      55,    55,    56,    57,    57,    58,    59,    59,    60,    60,
      61,    61,    61,    61,    61,    61,    62,    62,    63,    63,
      64,    64,    65,    65,    66,    66,    66,    66,    67,    68,
      68,    69,    69
};

/* YYR2[YYN] -- Number of symbols composing right hand side of rule YYN.  */
static const yytype_uint8 yyr2[] =
{
       0,     2,     1,     1,     2,     1,     1,     3,     6,     1,
       1,     0,     0,     8,     1,     1,     1,     3,     2,     4,
       0,     5,     0,     2,     0,     2,     1,     1,     1,     1,
       1,     1,     1,     1,     2,     1,     3,     5,     7,     5,
       2,     3,     3,     3,     3,     1,     1,     4,     1,     3,
       1,     1,     1,     1,     1,     1,     1,     3,     1,     1,
       1,     3,     1,     1,     3,     1,     1,     1,     4,     1,
       0,     1,     3
};

/* YYDEFACT[STATE-NAME] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE doesn't specify something else to do.  Zero
   means the default is an error.  */
static const yytype_uint8 yydefact[] =
{
       0,     9,    10,     0,     2,     3,     5,     0,     6,     1,
       4,     0,     7,     0,    11,     0,     0,     0,    10,     0,
      12,    15,    16,     8,    18,     0,     0,     0,     0,    17,
      19,    20,    13,    22,    22,     0,    24,    23,     0,    46,
      65,     0,     0,     0,     0,     0,    35,     0,    27,     0,
      24,    26,    30,    28,    29,    31,    32,    33,     0,    66,
      45,    48,    56,    60,    67,     0,    70,     0,     0,    40,
       0,    66,    46,     0,     0,     0,     0,    21,    25,    34,
       0,    50,    51,    53,    52,    54,    55,     0,    58,    59,
       0,    62,    63,     0,     0,    71,     0,    69,     0,     0,
      41,    42,    44,    43,    64,    36,    49,    57,    61,    47,
       0,    68,     0,     0,    72,    37,    39,     0,    38
};

/* YYDEFGOTO[NTERM-NUM].  */
static const yytype_int8 yydefgoto[] =
{
      -1,     3,     4,     5,     6,     7,     8,    16,    25,    20,
      21,    22,    48,    33,    36,    49,    50,    51,    52,    53,
      54,    55,    56,    57,    58,    71,    60,    87,    61,    90,
      62,    93,    63,    64,    96,    97
};

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
#define YYPACT_NINF -60
static const yytype_int8 yypact[] =
{
       0,   -60,   -60,    13,   -60,     0,   -60,    15,   -60,   -60,
     -60,    40,   -60,    11,   -60,    -1,    45,     8,    30,    60,
     -60,   -60,    49,   -60,    56,    42,     0,    10,    52,   -60,
     -60,   -60,   -60,     0,     0,    77,     7,   -60,    44,   -20,
     -60,    58,    59,     6,    81,    32,   -60,    35,   -60,    57,
       7,   -60,   -60,   -60,   -60,   -60,   -60,   -60,    65,    61,
      28,    39,    41,   -60,   -60,    35,    35,    35,    35,   -60,
      66,   -60,    67,    70,    71,    72,    63,   -60,   -60,   -60,
      36,   -60,   -60,   -60,   -60,   -60,   -60,    35,   -60,   -60,
      35,   -60,   -60,    35,    73,    68,    74,   -60,    75,    76,
     -60,   -60,   -60,   -60,   -60,   -60,    39,    41,   -60,   -60,
      35,   -60,     7,     7,   -60,    86,   -60,     7,   -60
};

/* YYPGOTO[NTERM-NUM].  */
static const yytype_int8 yypgoto[] =
{
     -60,   -60,    92,   -60,    38,    16,   -60,   -60,   -60,   -60,
      78,   -60,    79,   -60,    64,    53,   -59,    22,   -60,   -60,
     -60,   -60,   -60,   -60,   -42,   -36,   -60,   -60,    18,   -60,
      19,   -60,    17,   -60,   -60,    -4
};

/* YYTABLE[YYPACT[STATE-NUM]].  What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule which
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
#define YYTABLE_NINF -15
static const yytype_int8 yytable[] =
{
      59,    70,    65,    75,    66,    76,     1,     2,    73,    39,
      39,    40,    40,     9,    59,    41,    15,    42,    11,    43,
      44,    45,    17,    94,    95,    98,    99,    69,    46,    23,
      47,    47,    19,    30,    31,    39,    74,    40,    39,    39,
      40,    40,    19,    81,    82,    83,    84,    85,    86,    35,
      35,     1,    18,   115,   116,   -14,    47,    46,   118,    47,
      47,    12,    13,    24,    14,    12,    13,    28,    95,    88,
      89,    34,    34,    91,    92,    26,    59,    59,    27,    31,
      38,    59,    67,    68,    72,    77,    79,   100,   104,    65,
      80,   101,   102,   103,   110,   117,   109,    10,    37,   111,
     112,   113,   105,    78,    29,   106,   114,    32,     0,   107,
     108
};

#define yypact_value_is_default(Yystate) \
  (!!((Yystate) == (-60)))

#define yytable_value_is_error(Yytable_value) \
  YYID (0)

static const yytype_int8 yycheck[] =
{
      36,    43,    22,    45,    24,    47,     6,     7,    44,     3,
       3,     5,     5,     0,    50,     8,     5,    10,     3,    12,
      13,    14,    23,    65,    66,    67,    68,    21,    21,    21,
      24,    24,    16,    23,    27,     3,     4,     5,     3,     3,
       5,     5,    26,    15,    16,    17,    18,    19,    20,    33,
      34,     6,     7,   112,   113,    25,    24,    21,   117,    24,
      24,    21,    22,     3,    24,    21,    22,    25,   110,    30,
      31,    33,    34,    32,    33,    26,   112,   113,    22,    27,
       3,   117,    24,    24,     3,    28,    21,    21,    25,    22,
      29,    21,    21,    21,    26,     9,    23,     5,    34,    25,
      25,    25,    80,    50,    26,    87,   110,    28,    -1,    90,
      93
};

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
static const yytype_uint8 yystos[] =
{
       0,     6,     7,    35,    36,    37,    38,    39,    40,     0,
      36,     3,    21,    22,    24,     5,    41,    23,     7,    39,
      43,    44,    45,    21,     3,    42,    26,    22,    25,    44,
      23,    27,    46,    47,    38,    39,    48,    48,     3,     3,
       5,     8,    10,    12,    13,    14,    21,    24,    46,    49,
      50,    51,    52,    53,    54,    55,    56,    57,    58,    59,
      60,    62,    64,    66,    67,    22,    24,    24,    24,    21,
      58,    59,     3,    59,     4,    58,    58,    28,    49,    21,
      29,    15,    16,    17,    18,    19,    20,    61,    30,    31,
      63,    32,    33,    65,    58,    58,    68,    69,    58,    58,
      21,    21,    21,    21,    25,    51,    62,    64,    66,    23,
      26,    25,    25,    25,    69,    50,    50,     9,    50
};

#define yyerrok		(yyerrstatus = 0)
#define yyclearin	(yychar = YYEMPTY)
#define YYEMPTY		(-2)
#define YYEOF		0

#define YYACCEPT	goto yyacceptlab
#define YYABORT		goto yyabortlab
#define YYERROR		goto yyerrorlab


/* Like YYERROR except do call yyerror.  This remains here temporarily
   to ease the transition to the new meaning of YYERROR, for GCC.
   Once GCC version 2 has supplanted version 1, this can go.  However,
   YYFAIL appears to be in use.  Nevertheless, it is formally deprecated
   in Bison 2.4.2's NEWS entry, where a plan to phase it out is
   discussed.  */

#define YYFAIL		goto yyerrlab
#if defined YYFAIL
  /* This is here to suppress warnings from the GCC cpp's
     -Wunused-macros.  Normally we don't worry about that warning, but
     some users do, and we want to make it easy for users to remove
     YYFAIL uses, which will produce warnings from Bison 2.5.  */
#endif

#define YYRECOVERING()  (!!yyerrstatus)

#define YYBACKUP(Token, Value)                                  \
do                                                              \
  if (yychar == YYEMPTY)                                        \
    {                                                           \
      yychar = (Token);                                         \
      yylval = (Value);                                         \
      YYPOPSTACK (yylen);                                       \
      yystate = *yyssp;                                         \
      goto yybackup;                                            \
    }                                                           \
  else                                                          \
    {                                                           \
      yyerror (YY_("syntax error: cannot back up")); \
      YYERROR;							\
    }								\
while (YYID (0))

/* Error token number */
#define YYTERROR	1
#define YYERRCODE	256


/* This macro is provided for backward compatibility. */
#ifndef YY_LOCATION_PRINT
# define YY_LOCATION_PRINT(File, Loc) ((void) 0)
#endif


/* YYLEX -- calling `yylex' with the right arguments.  */
#ifdef YYLEX_PARAM
# define YYLEX yylex (YYLEX_PARAM)
#else
# define YYLEX yylex ()
#endif

/* Enable debugging if requested.  */
#if YYDEBUG

# ifndef YYFPRINTF
#  include <stdio.h> /* INFRINGES ON USER NAME SPACE */
#  define YYFPRINTF fprintf
# endif

# define YYDPRINTF(Args)			\
do {						\
  if (yydebug)					\
    YYFPRINTF Args;				\
} while (YYID (0))

# define YY_SYMBOL_PRINT(Title, Type, Value, Location)			  \
do {									  \
  if (yydebug)								  \
    {									  \
      YYFPRINTF (stderr, "%s ", Title);					  \
      yy_symbol_print (stderr,						  \
		  Type, Value); \
      YYFPRINTF (stderr, "\n");						  \
    }									  \
} while (YYID (0))


/*--------------------------------.
| Print this symbol on YYOUTPUT.  |
`--------------------------------*/

/*ARGSUSED*/
#if (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
static void
yy_symbol_value_print (FILE *yyoutput, int yytype, YYSTYPE const * const yyvaluep)
#else
static void
yy_symbol_value_print (yyoutput, yytype, yyvaluep)
    FILE *yyoutput;
    int yytype;
    YYSTYPE const * const yyvaluep;
#endif
{
  FILE *yyo = yyoutput;
  YYUSE (yyo);
  if (!yyvaluep)
    return;
# ifdef YYPRINT
  if (yytype < YYNTOKENS)
    YYPRINT (yyoutput, yytoknum[yytype], *yyvaluep);
# else
  YYUSE (yyoutput);
# endif
  switch (yytype)
    {
      default:
        break;
    }
}


/*--------------------------------.
| Print this symbol on YYOUTPUT.  |
`--------------------------------*/

#if (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
static void
yy_symbol_print (FILE *yyoutput, int yytype, YYSTYPE const * const yyvaluep)
#else
static void
yy_symbol_print (yyoutput, yytype, yyvaluep)
    FILE *yyoutput;
    int yytype;
    YYSTYPE const * const yyvaluep;
#endif
{
  if (yytype < YYNTOKENS)
    YYFPRINTF (yyoutput, "token %s (", yytname[yytype]);
  else
    YYFPRINTF (yyoutput, "nterm %s (", yytname[yytype]);

  yy_symbol_value_print (yyoutput, yytype, yyvaluep);
  YYFPRINTF (yyoutput, ")");
}

/*------------------------------------------------------------------.
| yy_stack_print -- Print the state stack from its BOTTOM up to its |
| TOP (included).                                                   |
`------------------------------------------------------------------*/

#if (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
static void
yy_stack_print (yytype_int16 *yybottom, yytype_int16 *yytop)
#else
static void
yy_stack_print (yybottom, yytop)
    yytype_int16 *yybottom;
    yytype_int16 *yytop;
#endif
{
  YYFPRINTF (stderr, "Stack now");
  for (; yybottom <= yytop; yybottom++)
    {
      int yybot = *yybottom;
      YYFPRINTF (stderr, " %d", yybot);
    }
  YYFPRINTF (stderr, "\n");
}

# define YY_STACK_PRINT(Bottom, Top)				\
do {								\
  if (yydebug)							\
    yy_stack_print ((Bottom), (Top));				\
} while (YYID (0))


/*------------------------------------------------.
| Report that the YYRULE is going to be reduced.  |
`------------------------------------------------*/

#if (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
static void
yy_reduce_print (YYSTYPE *yyvsp, int yyrule)
#else
static void
yy_reduce_print (yyvsp, yyrule)
    YYSTYPE *yyvsp;
    int yyrule;
#endif
{
  int yynrhs = yyr2[yyrule];
  int yyi;
  unsigned long int yylno = yyrline[yyrule];
  YYFPRINTF (stderr, "Reducing stack by rule %d (line %lu):\n",
	     yyrule - 1, yylno);
  /* The symbols being reduced.  */
  for (yyi = 0; yyi < yynrhs; yyi++)
    {
      YYFPRINTF (stderr, "   $%d = ", yyi + 1);
      yy_symbol_print (stderr, yyrhs[yyprhs[yyrule] + yyi],
		       &(yyvsp[(yyi + 1) - (yynrhs)])
		       		       );
      YYFPRINTF (stderr, "\n");
    }
}

# define YY_REDUCE_PRINT(Rule)		\
do {					\
  if (yydebug)				\
    yy_reduce_print (yyvsp, Rule); \
} while (YYID (0))

/* Nonzero means print parse trace.  It is left uninitialized so that
   multiple parsers can coexist.  */
int yydebug;
#else /* !YYDEBUG */
# define YYDPRINTF(Args)
# define YY_SYMBOL_PRINT(Title, Type, Value, Location)
# define YY_STACK_PRINT(Bottom, Top)
# define YY_REDUCE_PRINT(Rule)
#endif /* !YYDEBUG */


/* YYINITDEPTH -- initial size of the parser's stacks.  */
#ifndef	YYINITDEPTH
# define YYINITDEPTH 200
#endif

/* YYMAXDEPTH -- maximum size the stacks can grow to (effective only
   if the built-in stack extension method is used).

   Do not make this value too large; the results are undefined if
   YYSTACK_ALLOC_MAXIMUM < YYSTACK_BYTES (YYMAXDEPTH)
   evaluated with infinite-precision integer arithmetic.  */

#ifndef YYMAXDEPTH
# define YYMAXDEPTH 10000
#endif


#if YYERROR_VERBOSE

# ifndef yystrlen
#  if defined __GLIBC__ && defined _STRING_H
#   define yystrlen strlen
#  else
/* Return the length of YYSTR.  */
#if (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
static YYSIZE_T
yystrlen (const char *yystr)
#else
static YYSIZE_T
yystrlen (yystr)
    const char *yystr;
#endif
{
  YYSIZE_T yylen;
  for (yylen = 0; yystr[yylen]; yylen++)
    continue;
  return yylen;
}
#  endif
# endif

# ifndef yystpcpy
#  if defined __GLIBC__ && defined _STRING_H && defined _GNU_SOURCE
#   define yystpcpy stpcpy
#  else
/* Copy YYSRC to YYDEST, returning the address of the terminating '\0' in
   YYDEST.  */
#if (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
static char *
yystpcpy (char *yydest, const char *yysrc)
#else
static char *
yystpcpy (yydest, yysrc)
    char *yydest;
    const char *yysrc;
#endif
{
  char *yyd = yydest;
  const char *yys = yysrc;

  while ((*yyd++ = *yys++) != '\0')
    continue;

  return yyd - 1;
}
#  endif
# endif

# ifndef yytnamerr
/* Copy to YYRES the contents of YYSTR after stripping away unnecessary
   quotes and backslashes, so that it's suitable for yyerror.  The
   heuristic is that double-quoting is unnecessary unless the string
   contains an apostrophe, a comma, or backslash (other than
   backslash-backslash).  YYSTR is taken from yytname.  If YYRES is
   null, do not copy; instead, return the length of what the result
   would have been.  */
static YYSIZE_T
yytnamerr (char *yyres, const char *yystr)
{
  if (*yystr == '"')
    {
      YYSIZE_T yyn = 0;
      char const *yyp = yystr;

      for (;;)
	switch (*++yyp)
	  {
	  case '\'':
	  case ',':
	    goto do_not_strip_quotes;

	  case '\\':
	    if (*++yyp != '\\')
	      goto do_not_strip_quotes;
	    /* Fall through.  */
	  default:
	    if (yyres)
	      yyres[yyn] = *yyp;
	    yyn++;
	    break;

	  case '"':
	    if (yyres)
	      yyres[yyn] = '\0';
	    return yyn;
	  }
    do_not_strip_quotes: ;
    }

  if (! yyres)
    return yystrlen (yystr);

  return yystpcpy (yyres, yystr) - yyres;
}
# endif

/* Copy into *YYMSG, which is of size *YYMSG_ALLOC, an error message
   about the unexpected token YYTOKEN for the state stack whose top is
   YYSSP.

   Return 0 if *YYMSG was successfully written.  Return 1 if *YYMSG is
   not large enough to hold the message.  In that case, also set
   *YYMSG_ALLOC to the required number of bytes.  Return 2 if the
   required number of bytes is too large to store.  */
static int
yysyntax_error (YYSIZE_T *yymsg_alloc, char **yymsg,
                yytype_int16 *yyssp, int yytoken)
{
  YYSIZE_T yysize0 = yytnamerr (YY_NULL, yytname[yytoken]);
  YYSIZE_T yysize = yysize0;
  enum { YYERROR_VERBOSE_ARGS_MAXIMUM = 5 };
  /* Internationalized format string. */
  const char *yyformat = YY_NULL;
  /* Arguments of yyformat. */
  char const *yyarg[YYERROR_VERBOSE_ARGS_MAXIMUM];
  /* Number of reported tokens (one for the "unexpected", one per
     "expected"). */
  int yycount = 0;

  /* There are many possibilities here to consider:
     - Assume YYFAIL is not used.  It's too flawed to consider.  See
       <http://lists.gnu.org/archive/html/bison-patches/2009-12/msg00024.html>
       for details.  YYERROR is fine as it does not invoke this
       function.
     - If this state is a consistent state with a default action, then
       the only way this function was invoked is if the default action
       is an error action.  In that case, don't check for expected
       tokens because there are none.
     - The only way there can be no lookahead present (in yychar) is if
       this state is a consistent state with a default action.  Thus,
       detecting the absence of a lookahead is sufficient to determine
       that there is no unexpected or expected token to report.  In that
       case, just report a simple "syntax error".
     - Don't assume there isn't a lookahead just because this state is a
       consistent state with a default action.  There might have been a
       previous inconsistent state, consistent state with a non-default
       action, or user semantic action that manipulated yychar.
     - Of course, the expected token list depends on states to have
       correct lookahead information, and it depends on the parser not
       to perform extra reductions after fetching a lookahead from the
       scanner and before detecting a syntax error.  Thus, state merging
       (from LALR or IELR) and default reductions corrupt the expected
       token list.  However, the list is correct for canonical LR with
       one exception: it will still contain any token that will not be
       accepted due to an error action in a later state.
  */
  if (yytoken != YYEMPTY)
    {
      int yyn = yypact[*yyssp];
      yyarg[yycount++] = yytname[yytoken];
      if (!yypact_value_is_default (yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative indexes in
             YYCHECK.  In other words, skip the first -YYN actions for
             this state because they are default actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST - yyn + 1;
          int yyxend = yychecklim < YYNTOKENS ? yychecklim : YYNTOKENS;
          int yyx;

          for (yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck[yyx + yyn] == yyx && yyx != YYTERROR
                && !yytable_value_is_error (yytable[yyx + yyn]))
              {
                if (yycount == YYERROR_VERBOSE_ARGS_MAXIMUM)
                  {
                    yycount = 1;
                    yysize = yysize0;
                    break;
                  }
                yyarg[yycount++] = yytname[yyx];
                {
                  YYSIZE_T yysize1 = yysize + yytnamerr (YY_NULL, yytname[yyx]);
                  if (! (yysize <= yysize1
                         && yysize1 <= YYSTACK_ALLOC_MAXIMUM))
                    return 2;
                  yysize = yysize1;
                }
              }
        }
    }

  switch (yycount)
    {
# define YYCASE_(N, S)                      \
      case N:                               \
        yyformat = S;                       \
      break
      YYCASE_(0, YY_("syntax error"));
      YYCASE_(1, YY_("syntax error, unexpected %s"));
      YYCASE_(2, YY_("syntax error, unexpected %s, expecting %s"));
      YYCASE_(3, YY_("syntax error, unexpected %s, expecting %s or %s"));
      YYCASE_(4, YY_("syntax error, unexpected %s, expecting %s or %s or %s"));
      YYCASE_(5, YY_("syntax error, unexpected %s, expecting %s or %s or %s or %s"));
# undef YYCASE_
    }

  {
    YYSIZE_T yysize1 = yysize + yystrlen (yyformat);
    if (! (yysize <= yysize1 && yysize1 <= YYSTACK_ALLOC_MAXIMUM))
      return 2;
    yysize = yysize1;
  }

  if (*yymsg_alloc < yysize)
    {
      *yymsg_alloc = 2 * yysize;
      if (! (yysize <= *yymsg_alloc
             && *yymsg_alloc <= YYSTACK_ALLOC_MAXIMUM))
        *yymsg_alloc = YYSTACK_ALLOC_MAXIMUM;
      return 1;
    }

  /* Avoid sprintf, as that infringes on the user's name space.
     Don't have undefined behavior even if the translation
     produced a string with the wrong number of "%s"s.  */
  {
    char *yyp = *yymsg;
    int yyi = 0;
    while ((*yyp = *yyformat) != '\0')
      if (*yyp == '%' && yyformat[1] == 's' && yyi < yycount)
        {
          yyp += yytnamerr (yyp, yyarg[yyi++]);
          yyformat += 2;
        }
      else
        {
          yyp++;
          yyformat++;
        }
  }
  return 0;
}
#endif /* YYERROR_VERBOSE */

/*-----------------------------------------------.
| Release the memory associated to this symbol.  |
`-----------------------------------------------*/

/*ARGSUSED*/
#if (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
static void
yydestruct (const char *yymsg, int yytype, YYSTYPE *yyvaluep)
#else
static void
yydestruct (yymsg, yytype, yyvaluep)
    const char *yymsg;
    int yytype;
    YYSTYPE *yyvaluep;
#endif
{
  YYUSE (yyvaluep);

  if (!yymsg)
    yymsg = "Deleting";
  YY_SYMBOL_PRINT (yymsg, yytype, yyvaluep, yylocationp);

  switch (yytype)
    {

      default:
        break;
    }
}




/* The lookahead symbol.  */
int yychar;


#ifndef YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_END
#endif
#ifndef YY_INITIAL_VALUE
# define YY_INITIAL_VALUE(Value) /* Nothing. */
#endif

/* The semantic value of the lookahead symbol.  */
YYSTYPE yylval YY_INITIAL_VALUE(yyval_default);

/* Number of syntax errors so far.  */
int yynerrs;


/*----------.
| yyparse.  |
`----------*/

#ifdef YYPARSE_PARAM
#if (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
int
yyparse (void *YYPARSE_PARAM)
#else
int
yyparse (YYPARSE_PARAM)
    void *YYPARSE_PARAM;
#endif
#else /* ! YYPARSE_PARAM */
#if (defined __STDC__ || defined __C99__FUNC__ \
     || defined __cplusplus || defined _MSC_VER)
int
yyparse (void)
#else
int
yyparse ()

#endif
#endif
{
    int yystate;
    /* Number of tokens to shift before error messages enabled.  */
    int yyerrstatus;

    /* The stacks and their tools:
       `yyss': related to states.
       `yyvs': related to semantic values.

       Refer to the stacks through separate pointers, to allow yyoverflow
       to reallocate them elsewhere.  */

    /* The state stack.  */
    yytype_int16 yyssa[YYINITDEPTH];
    yytype_int16 *yyss;
    yytype_int16 *yyssp;

    /* The semantic value stack.  */
    YYSTYPE yyvsa[YYINITDEPTH];
    YYSTYPE *yyvs;
    YYSTYPE *yyvsp;

    YYSIZE_T yystacksize;

  int yyn;
  int yyresult;
  /* Lookahead token as an internal (translated) token number.  */
  int yytoken = 0;
  /* The variables used to return semantic value and location from the
     action routines.  */
  YYSTYPE yyval;

#if YYERROR_VERBOSE
  /* Buffer for error messages, and its allocated size.  */
  char yymsgbuf[128];
  char *yymsg = yymsgbuf;
  YYSIZE_T yymsg_alloc = sizeof yymsgbuf;
#endif

#define YYPOPSTACK(N)   (yyvsp -= (N), yyssp -= (N))

  /* The number of symbols on the RHS of the reduced rule.
     Keep to zero when no symbol should be popped.  */
  int yylen = 0;

  yyssp = yyss = yyssa;
  yyvsp = yyvs = yyvsa;
  yystacksize = YYINITDEPTH;

  YYDPRINTF ((stderr, "Starting parse\n"));

  yystate = 0;
  yyerrstatus = 0;
  yynerrs = 0;
  yychar = YYEMPTY; /* Cause a token to be read.  */
  goto yysetstate;

/*------------------------------------------------------------.
| yynewstate -- Push a new state, which is found in yystate.  |
`------------------------------------------------------------*/
 yynewstate:
  /* In all cases, when you get here, the value and location stacks
     have just been pushed.  So pushing a state here evens the stacks.  */
  yyssp++;

 yysetstate:
  *yyssp = yystate;

  if (yyss + yystacksize - 1 <= yyssp)
    {
      /* Get the current used size of the three stacks, in elements.  */
      YYSIZE_T yysize = yyssp - yyss + 1;

#ifdef yyoverflow
      {
	/* Give user a chance to reallocate the stack.  Use copies of
	   these so that the &'s don't force the real ones into
	   memory.  */
	YYSTYPE *yyvs1 = yyvs;
	yytype_int16 *yyss1 = yyss;

	/* Each stack pointer address is followed by the size of the
	   data in use in that stack, in bytes.  This used to be a
	   conditional around just the two extra args, but that might
	   be undefined if yyoverflow is a macro.  */
	yyoverflow (YY_("memory exhausted"),
		    &yyss1, yysize * sizeof (*yyssp),
		    &yyvs1, yysize * sizeof (*yyvsp),
		    &yystacksize);

	yyss = yyss1;
	yyvs = yyvs1;
      }
#else /* no yyoverflow */
# ifndef YYSTACK_RELOCATE
      goto yyexhaustedlab;
# else
      /* Extend the stack our own way.  */
      if (YYMAXDEPTH <= yystacksize)
	goto yyexhaustedlab;
      yystacksize *= 2;
      if (YYMAXDEPTH < yystacksize)
	yystacksize = YYMAXDEPTH;

      {
	yytype_int16 *yyss1 = yyss;
	union yyalloc *yyptr =
	  (union yyalloc *) YYSTACK_ALLOC (YYSTACK_BYTES (yystacksize));
	if (! yyptr)
	  goto yyexhaustedlab;
	YYSTACK_RELOCATE (yyss_alloc, yyss);
	YYSTACK_RELOCATE (yyvs_alloc, yyvs);
#  undef YYSTACK_RELOCATE
	if (yyss1 != yyssa)
	  YYSTACK_FREE (yyss1);
      }
# endif
#endif /* no yyoverflow */

      yyssp = yyss + yysize - 1;
      yyvsp = yyvs + yysize - 1;

      YYDPRINTF ((stderr, "Stack size increased to %lu\n",
		  (unsigned long int) yystacksize));

      if (yyss + yystacksize - 1 <= yyssp)
	YYABORT;
    }

  YYDPRINTF ((stderr, "Entering state %d\n", yystate));

  if (yystate == YYFINAL)
    YYACCEPT;

  goto yybackup;

/*-----------.
| yybackup.  |
`-----------*/
yybackup:

  /* Do appropriate processing given the current state.  Read a
     lookahead token if we need one and don't already have one.  */

  /* First try to decide what to do without reference to lookahead token.  */
  yyn = yypact[yystate];
  if (yypact_value_is_default (yyn))
    goto yydefault;

  /* Not known => get a lookahead token if don't already have one.  */

  /* YYCHAR is either YYEMPTY or YYEOF or a valid lookahead symbol.  */
  if (yychar == YYEMPTY)
    {
      YYDPRINTF ((stderr, "Reading a token: "));
      yychar = YYLEX;
    }

  if (yychar <= YYEOF)
    {
      yychar = yytoken = YYEOF;
      YYDPRINTF ((stderr, "Now at end of input.\n"));
    }
  else
    {
      yytoken = YYTRANSLATE (yychar);
      YY_SYMBOL_PRINT ("Next token is", yytoken, &yylval, &yylloc);
    }

  /* If the proper action on seeing token YYTOKEN is to reduce or to
     detect an error, take that action.  */
  yyn += yytoken;
  if (yyn < 0 || YYLAST < yyn || yycheck[yyn] != yytoken)
    goto yydefault;
  yyn = yytable[yyn];
  if (yyn <= 0)
    {
      if (yytable_value_is_error (yyn))
        goto yyerrlab;
      yyn = -yyn;
      goto yyreduce;
    }

  /* Count tokens shifted since error; after three, turn off error
     status.  */
  if (yyerrstatus)
    yyerrstatus--;

  /* Shift the lookahead token.  */
  YY_SYMBOL_PRINT ("Shifting", yytoken, &yylval, &yylloc);

  /* Discard the shifted token.  */
  yychar = YYEMPTY;

  yystate = yyn;
  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END

  goto yynewstate;


/*-----------------------------------------------------------.
| yydefault -- do the default action for the current state.  |
`-----------------------------------------------------------*/
yydefault:
  yyn = yydefact[yystate];
  if (yyn == 0)
    goto yyerrlab;
  goto yyreduce;


/*-----------------------------.
| yyreduce -- Do a reduction.  |
`-----------------------------*/
yyreduce:
  /* yyn is the number of a rule to reduce with.  */
  yylen = yyr2[yyn];

  /* If YYLEN is nonzero, implement the default value of the action:
     `$$ = $1'.

     Otherwise, the following line sets YYVAL to garbage.
     This behavior is undocumented and Bison
     users should not rely upon it.  Assigning to YYVAL
     unconditionally makes the parser a bit smaller, and it avoids a
     GCC warning that YYVAL may be used uninitialized.  */
  yyval = yyvsp[1-yylen];


  YY_REDUCE_PRINT (yyn);
  switch (yyn)
    {
        case 2:
/* Line 1792 of yacc.c  */
#line 56 "lab9.y"
    {program=(yyvsp[(1) - (1)].node);}
    break;

  case 3:
/* Line 1792 of yacc.c  */
#line 59 "lab9.y"
    { (yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 4:
/* Line 1792 of yacc.c  */
#line 60 "lab9.y"
    {(yyvsp[(1) - (2)].node)->next=(yyvsp[(2) - (2)].node); (yyval.node)= (yyvsp[(1) - (2)].node); /*left connect declarations */
                       // if (mydebug)  ASTprint(0,$1);
                        //if (mydebug) ASTprint(0,$2);
                       }
    break;

  case 5:
/* Line 1792 of yacc.c  */
#line 66 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 6:
/* Line 1792 of yacc.c  */
#line 67 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 7:
/* Line 1792 of yacc.c  */
#line 70 "lab9.y"
    {
			  if(Search((yyvsp[(2) - (3)].string),level,0) == NULL){//if symbol not used insert into symbol table 
				(yyval.node)=ASTCreateNode(VARDEC); 
				(yyval.node)->operator=(yyvsp[(1) - (3)].operator); 
				(yyval.node)->istype=(yyvsp[(1) - (3)].operator);
				(yyval.node)->symbol=Insert((yyvsp[(2) - (3)].string),(yyvsp[(1) - (3)].operator),0,level,1,off,NULL);
				(yyval.node)->name=(yyvsp[(2) - (3)].string);
				off+=1;
				//Display();
			  }
			  else{
				//yyerror($2);
				yyerror("Symbol already used ");
				exit(1);
			  }
		      }
    break;

  case 8:
/* Line 1792 of yacc.c  */
#line 86 "lab9.y"
    {
				
			   if(Search((yyvsp[(2) - (6)].string),level,0) == NULL){//if array not in symbol table insert 
				(yyval.node)=ASTCreateNode(VARDEC);
				(yyval.node)->operator=(yyvsp[(1) - (6)].operator);
				(yyval.node)->istype=(yyvsp[(1) - (6)].operator); 
		                (yyval.node)->name=(yyvsp[(2) - (6)].string); /* this changes to symbol table*/
		                (yyval.node)->value=(yyvsp[(4) - (6)].value); /* remember dimension*/
				(yyval.node)->symbol=Insert((yyvsp[(2) - (6)].string),(yyvsp[(1) - (6)].operator),2,level,(yyvsp[(4) - (6)].value),off,NULL);
				off+=(yyvsp[(4) - (6)].value);
		                //printf("found an array declaration \n");
                  	  }
			  else{
				//yyerror($2);
				yyerror("Symbol already used ");
				exit(1);
			 }
		      }
    break;

  case 9:
/* Line 1792 of yacc.c  */
#line 106 "lab9.y"
    {(yyval.operator)=INTTYPE;}
    break;

  case 10:
/* Line 1792 of yacc.c  */
#line 107 "lab9.y"
    {(yyval.operator)=VOIDTYPE;}
    break;

  case 11:
/* Line 1792 of yacc.c  */
#line 110 "lab9.y"
    {
				 if (Search((yyvsp[(2) - (3)].string),level,0)==NULL){
					Insert((yyvsp[(2) - (3)].string),(yyvsp[(1) - (3)].operator),1,level,0,0,NULL);
					goff=off;//store current offset
					off=2;
                                        maxoffset=off;
				}
				else{
					//yyerror($2);
					yyerror("Symbol already used ");
					exit(1);
				}
			}
    break;

  case 12:
/* Line 1792 of yacc.c  */
#line 123 "lab9.y"
    {
				(Search((yyvsp[(2) - (5)].string),0,0))->fparms = (yyvsp[(5) - (5)].node);//pointer to params
			}
    break;

  case 13:
/* Line 1792 of yacc.c  */
#line 128 "lab9.y"
    {

				(yyval.node)=ASTCreateNode(FUNCTIONDEC);
				(yyval.node)->operator=(yyvsp[(1) - (8)].operator); 
				(yyval.node)->istype=(yyvsp[(1) - (8)].operator);
                            	(yyval.node)->name=(yyvsp[(2) - (8)].string); /* this changes to symbol table*/
				(yyval.node)->left=(yyvsp[(5) - (8)].node);
                            	(yyval.node)->right = (yyvsp[(8) - (8)].node); /* compound statement */
				(yyval.node)->symbol = Search((yyvsp[(2) - (8)].string),0,0);
                                (yyval.node)->value= maxoffset;
                                (yyval.node)->symbol->mysize=maxoffset;

				off-=Delete(1);//decide how much to decrement of stack pointer 
				level=0;
				off=goff;//back to normal offset 				
				
                        }
    break;

  case 14:
/* Line 1792 of yacc.c  */
#line 147 "lab9.y"
    {(yyval.node)=NULL;}
    break;

  case 15:
/* Line 1792 of yacc.c  */
#line 148 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 16:
/* Line 1792 of yacc.c  */
#line 151 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 17:
/* Line 1792 of yacc.c  */
#line 152 "lab9.y"
    {(yyvsp[(1) - (3)].node)->next=(yyvsp[(3) - (3)].node);
				(yyval.node)=(yyvsp[(1) - (3)].node);
			}
    break;

  case 18:
/* Line 1792 of yacc.c  */
#line 157 "lab9.y"
    {
			//if(mydebug) Display();
			   if(Search((yyvsp[(2) - (2)].string),level+1,0)==NULL){//insert param to symbol table if it isn't already 
				(yyval.node)=ASTCreateNode(PARAM);
				(yyval.node)->operator=(yyvsp[(1) - (2)].operator);
				(yyval.node)->istype=(yyvsp[(1) - (2)].operator);
				(yyval.node)->name=(yyvsp[(2) - (2)].string);
				(yyval.node)->symbol=Insert((yyvsp[(2) - (2)].string),(yyvsp[(1) - (2)].operator),0,level+1,1,off,NULL);
				//mydebug && printf("in param insert %s %d\n",$2,level+1);
			   	//if(mydebug) Display();
			   	(yyval.node)->value = 0;
			   	off+=1;
			   }
		           else{
				//yyerror($2);
				yyerror("Symbol already used ");
				exit(1);
			   }
			}
    break;

  case 19:
/* Line 1792 of yacc.c  */
#line 176 "lab9.y"
    {
				if(Search((yyvsp[(2) - (4)].string),level+1,0) == NULL){		
					(yyval.node)=ASTCreateNode(PARAM);
					(yyval.node)->operator=(yyvsp[(1) - (4)].operator);
					(yyval.node)->istype=(yyvsp[(1) - (4)].operator); 
					(yyval.node)->name=(yyvsp[(2) - (4)].string);
					(yyval.node)->symbol=Insert((yyvsp[(2) - (4)].string),(yyvsp[(1) - (4)].operator),2,level+1,1,off,NULL);
					(yyval.node)->value=-1;
					off+=1;
				}
				else{
					//yyerror($2);
					yyerror("Symbol already used ");
					exit(1);
				}
			}
    break;

  case 20:
/* Line 1792 of yacc.c  */
#line 194 "lab9.y"
    { level++;}
    break;

  case 21:
/* Line 1792 of yacc.c  */
#line 195 "lab9.y"
    { 
				
				(yyval.node)=ASTCreateNode(BLOCK);
                         	if ((yyvsp[(3) - (5)].node)==NULL){ /* no local declarations */
                                	(yyval.node)->right=(yyvsp[(4) - (5)].node);}
                        	else{ /* we had some declarations, put them together */
					(yyval.node)->left=(yyvsp[(3) - (5)].node);                             		
					(yyval.node)->right=(yyvsp[(4) - (5)].node);}//ASTattachleft($3,$4);
                           	if (off > maxoffset) maxoffset=off;
				//Display();  /* display symbol table as per requirement */
                        	off-=Delete(level);  /* decrease the offset count by the size of values allocated at level */
                        	level--;  /* down one level */
                       }
    break;

  case 22:
/* Line 1792 of yacc.c  */
#line 210 "lab9.y"
    { (yyval.node)=NULL;}
    break;

  case 23:
/* Line 1792 of yacc.c  */
#line 211 "lab9.y"
    {
				
					(yyvsp[(1) - (2)].node)->next=(yyvsp[(2) - (2)].node); 
					(yyval.node)=(yyvsp[(1) - (2)].node);
				}
    break;

  case 24:
/* Line 1792 of yacc.c  */
#line 219 "lab9.y"
    { (yyval.node)=NULL;}
    break;

  case 25:
/* Line 1792 of yacc.c  */
#line 220 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (2)].node); (yyvsp[(1) - (2)].node)->next=(yyvsp[(2) - (2)].node); }
    break;

  case 26:
/* Line 1792 of yacc.c  */
#line 223 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 27:
/* Line 1792 of yacc.c  */
#line 224 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 28:
/* Line 1792 of yacc.c  */
#line 225 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 29:
/* Line 1792 of yacc.c  */
#line 226 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 30:
/* Line 1792 of yacc.c  */
#line 227 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 31:
/* Line 1792 of yacc.c  */
#line 228 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 32:
/* Line 1792 of yacc.c  */
#line 229 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 33:
/* Line 1792 of yacc.c  */
#line 230 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 34:
/* Line 1792 of yacc.c  */
#line 233 "lab9.y"
    { printf(" test exprstmt\n");
				(yyval.node)=ASTCreateNode(EXPRSTMT);
                                (yyval.node)->right=(yyvsp[(1) - (2)].node);
				(yyval.node)->istype=(yyvsp[(1) - (2)].node)->istype;
				(yyval.node)->name = CreateTemp();
     //printf("Here1\n");
			(yyval.node)->symbol=Insert((yyval.node)->name, (yyval.node)->istype, 0, level, 1, off, NULL);
			off+=1;					
			}
    break;

  case 35:
/* Line 1792 of yacc.c  */
#line 242 "lab9.y"
    { (yyval.node)=NULL; }
    break;

  case 36:
/* Line 1792 of yacc.c  */
#line 245 "lab9.y"
    {
			//printf("%d \n",$1->istype);
			if(((yyvsp[(1) - (3)].node)->istype != (yyvsp[(3) - (3)].node)->istype) || ((yyvsp[(1) - (3)].node)->type == VOIDTYPE)){//type checking and making sure not void 
				yyerror("error in assingment statement ");
				exit(1);
			}
			
				(yyval.node)=ASTCreateNode(ASSIGN);
                          /* Assignment statement  we leave left alone so that
                             it can be strung with other statements	*/ 
                              	(yyval.node)->right=(yyvsp[(1) - (3)].node);//right var
                              	(yyval.node)->s1=(yyvsp[(3) - (3)].node);//s1 exprstmt
                      }
    break;

  case 37:
/* Line 1792 of yacc.c  */
#line 260 "lab9.y"
    { (yyval.node)=ASTCreateNode(IFSTMT);
                                                  (yyval.node)->right=(yyvsp[(3) - (5)].node);
                                                  (yyval.node)->s1=(yyvsp[(5) - (5)].node);
                                                  (yyval.node)->s2=NULL;
                                                }
    break;

  case 38:
/* Line 1792 of yacc.c  */
#line 265 "lab9.y"
    { (yyval.node)=ASTCreateNode(IFSTMT);
						  (yyval.node)->right=(yyvsp[(3) - (7)].node);
						  (yyval.node)->s1=(yyvsp[(5) - (7)].node);
						  (yyval.node)->s2=(yyvsp[(7) - (7)].node);
						}
    break;

  case 39:
/* Line 1792 of yacc.c  */
#line 272 "lab9.y"
    {(yyval.node)=ASTCreateNode(WHILESTMT);
						    (yyval.node)->right=(yyvsp[(3) - (5)].node);
						    (yyval.node)->s1=(yyvsp[(5) - (5)].node);
						   
				}
    break;

  case 40:
/* Line 1792 of yacc.c  */
#line 279 "lab9.y"
    { (yyval.node)=ASTCreateNode(RETURNSTMT); (yyval.node)->right=NULL;}
    break;

  case 41:
/* Line 1792 of yacc.c  */
#line 280 "lab9.y"
    { (yyval.node)=ASTCreateNode(RETURNSTMT);
				            (yyval.node)->right=(yyvsp[(2) - (3)].node); 
					    (yyval.node)->name = CreateTemp();
					    (yyval.node)->symbol=Insert((yyval.node)->name, (yyval.node)->istype, 0, level, 1, off, NULL);
				            off+=1; 
				}
    break;

  case 42:
/* Line 1792 of yacc.c  */
#line 288 "lab9.y"
    { /* make sure variable is in symbol table */
                          /*  Create a ASTnode for this statement on the right */
                            (yyval.node)=ASTCreateNode(READSTMT);
                          /* this will be pointer to symbol table */
                            (yyval.node)->right=(yyvsp[(2) - (3)].node);
                        }
    break;

  case 43:
/* Line 1792 of yacc.c  */
#line 296 "lab9.y"
    { (yyval.node)=ASTCreateNode(WRITESTMT);
					(yyval.node)->right=(yyvsp[(2) - (3)].node);
			}
    break;

  case 44:
/* Line 1792 of yacc.c  */
#line 299 "lab9.y"
    { (yyval.node)=ASTCreateNode(WRITESTMT);
					(yyval.node)->stringVal=CreateTempL();
					(yyval.node)->name = (yyvsp[(2) - (3)].string); 
			}
    break;

  case 45:
/* Line 1792 of yacc.c  */
#line 305 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 46:
/* Line 1792 of yacc.c  */
#line 311 "lab9.y"
    {
				struct SymbTab * p;
				if((p=Search((yyvsp[(1) - (1)].string),level,1)) != NULL){ 

					(yyval.node)=ASTCreateNode(IDENT);
			    		(yyval.node)->name=(yyvsp[(1) - (1)].string);
					(yyval.node)->symbol=p;
					(yyval.node)->istype=p->Type;
					if(p->IsAFunc == 1){
						//yyerror($1);
						yyerror("Variable not a function, syntax error ");
						exit(1);
					}//end if 
				}

				else{
					//yyerror($1);
					yyerror("Undeclared variables ");
					exit(1);
				}
						
			}
    break;

  case 47:
/* Line 1792 of yacc.c  */
#line 333 "lab9.y"
    {
				struct SymbTab * p;	
				if((p=Search((yyvsp[(1) - (4)].string),level,1)) != NULL){

					(yyval.node)=ASTCreateNode(IDENT);
					(yyval.node)->name=(yyvsp[(1) - (4)].string);
					(yyval.node)->right=(yyvsp[(3) - (4)].node);

					(yyval.node)->istype=p->Type; 
					if(p->IsAFunc == 2){//if array okay if not error
						(yyval.node)->symbol = p;
						
					}
					else{
						yyerror("here3, syntax error ");
						exit(1);
					}	

				}

				else {
					//yyerror($1);
					yyerror("Undeclared variables here2 ");
					exit(1);
                                   }
                        }
    break;

  case 48:
/* Line 1792 of yacc.c  */
#line 361 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 49:
/* Line 1792 of yacc.c  */
#line 362 "lab9.y"
    {
			if(((yyvsp[(1) - (3)].node)->istype) != ((yyvsp[(3) - (3)].node)->istype)){

				yyerror("type relop mismatch");
				exit(1);
			}

			(yyval.node)=ASTCreateNode(EXPR);
                        (yyval.node)->left=(yyvsp[(1) - (3)].node);
			(yyval.node)->operator=(yyvsp[(2) - (3)].operator);
                        (yyval.node)->right=(yyvsp[(3) - (3)].node);
			(yyval.node)->istype = (yyvsp[(1) - (3)].node)->istype;
			(yyval.node)->name = CreateTemp();//create temp value 
			(yyval.node)->symbol = Insert((yyval.node)->name, (yyval.node)->istype, 0, level, 1, off, NULL);//insert temp to symbol table 
			off+=1;
                       }
    break;

  case 50:
/* Line 1792 of yacc.c  */
#line 380 "lab9.y"
    {(yyval.operator)=LESSTHANEQUAL;}
    break;

  case 51:
/* Line 1792 of yacc.c  */
#line 381 "lab9.y"
    {(yyval.operator)=LESSTHAN;}
    break;

  case 52:
/* Line 1792 of yacc.c  */
#line 382 "lab9.y"
    {(yyval.operator)=GREATERTHAN;}
    break;

  case 53:
/* Line 1792 of yacc.c  */
#line 383 "lab9.y"
    {(yyval.operator)=GREATERTHANEQUAL;}
    break;

  case 54:
/* Line 1792 of yacc.c  */
#line 384 "lab9.y"
    {(yyval.operator)=EQUAL;}
    break;

  case 55:
/* Line 1792 of yacc.c  */
#line 385 "lab9.y"
    {(yyval.operator)=NOTEQUAL;}
    break;

  case 56:
/* Line 1792 of yacc.c  */
#line 388 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 57:
/* Line 1792 of yacc.c  */
#line 389 "lab9.y"
    {
			if(((yyvsp[(1) - (3)].node)->istype) != ((yyvsp[(3) - (3)].node)->istype)){//type checking 

				yyerror("type mismatch");
				exit(1);
			}


			(yyval.node)=ASTCreateNode(EXPR);
                        (yyval.node)->left=(yyvsp[(1) - (3)].node);
			(yyval.node)->operator=(yyvsp[(2) - (3)].operator);
                        (yyval.node)->right=(yyvsp[(3) - (3)].node);
			(yyval.node)->istype = (yyvsp[(1) - (3)].node)->istype;//inheritence 
			(yyval.node)->name = CreateTemp();
     //printf("Here1\n");
			(yyval.node)->symbol=Insert((yyval.node)->name, (yyval.node)->istype, 0, level, 1, off, NULL);
			off+=1;
                        }
    break;

  case 58:
/* Line 1792 of yacc.c  */
#line 409 "lab9.y"
    {(yyval.operator)=PLUS;}
    break;

  case 59:
/* Line 1792 of yacc.c  */
#line 410 "lab9.y"
    {(yyval.operator)=MINUS;}
    break;

  case 60:
/* Line 1792 of yacc.c  */
#line 413 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 61:
/* Line 1792 of yacc.c  */
#line 414 "lab9.y"
    {
			if(((yyvsp[(1) - (3)].node)->istype) != ((yyvsp[(3) - (3)].node)->istype)){

				yyerror("type mismatch");
				exit(1);
			}


			(yyval.node)=ASTCreateNode(EXPR);
                        (yyval.node)->left=(yyvsp[(1) - (3)].node);
			(yyval.node)->operator=(yyvsp[(2) - (3)].operator);
                        (yyval.node)->right=(yyvsp[(3) - (3)].node);
			(yyval.node)->istype = (yyvsp[(1) - (3)].node)->istype;
			(yyval.node)->name = CreateTemp();
			(yyval.node)->symbol=Insert((yyval.node)->name, (yyval.node)->istype, 0, level, 1, off, NULL);
			off+=1;
                        }
    break;

  case 62:
/* Line 1792 of yacc.c  */
#line 433 "lab9.y"
    {(yyval.operator)=TIMES;}
    break;

  case 63:
/* Line 1792 of yacc.c  */
#line 434 "lab9.y"
    {(yyval.operator)=DIVIDE;}
    break;

  case 64:
/* Line 1792 of yacc.c  */
#line 437 "lab9.y"
    {(yyval.node)=(yyvsp[(2) - (3)].node);}
    break;

  case 65:
/* Line 1792 of yacc.c  */
#line 438 "lab9.y"
    { (yyval.node)=ASTCreateNode(NUMBER);
                        (yyval.node)->value=(yyvsp[(1) - (1)].value);
			(yyval.node)->istype=INTTYPE;  //num is always type INT
		  }
    break;

  case 66:
/* Line 1792 of yacc.c  */
#line 442 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 67:
/* Line 1792 of yacc.c  */
#line 443 "lab9.y"
    {(yyval.node)=(yyvsp[(1) - (1)].node);}
    break;

  case 68:
/* Line 1792 of yacc.c  */
#line 447 "lab9.y"
    { 
				struct SymbTab * p; 
int s;
				if((p=Search((yyvsp[(1) - (4)].string),0,0)) != NULL){

					if(p->IsAFunc != 1){//check if is function 
						
						yyerror("Not a function ");
						exit(1);
					}
                        s=(CompareFormals(p->fparms,(yyvsp[(3) - (4)].node)));
//printf("CF restuls is %d\n",s);
					if(CompareFormals(p->fparms,(yyvsp[(3) - (4)].node))==0){//compare parameter list 
						
						yyerror("Param length not same or type mismatch ");
						exit(1);
					}
			    		(yyval.node)=ASTCreateNode(CALL);
                            		(yyval.node)->name=(yyvsp[(1) - (4)].string);
					(yyval.node)->symbol=p;
					(yyval.node)->istype=p->Type;
			    		(yyval.node)->right=(yyvsp[(3) - (4)].node);
					(yyval.node)->value = p->mysize;
                             /*symbol table check */
				}

				else{
					
					yyerror("function name not defined!");
					exit(1);
				}
                         }
    break;

  case 69:
/* Line 1792 of yacc.c  */
#line 481 "lab9.y"
    {(yyval.node) = (yyvsp[(1) - (1)].node);}
    break;

  case 70:
/* Line 1792 of yacc.c  */
#line 482 "lab9.y"
    {(yyval.node)=NULL;}
    break;

  case 71:
/* Line 1792 of yacc.c  */
#line 485 "lab9.y"
    {(yyval.node)=ASTCreateNode(ARGLIST);
            			   (yyval.node)->left=(yyvsp[(1) - (1)].node);
				   (yyval.node)->next=NULL;
			           (yyval.node)->istype=(yyvsp[(1) - (1)].node)->istype;//inheritence 
				   (yyval.node)->name = CreateTemp();
				   (yyval.node)->symbol=Insert((yyval.node)->name, (yyval.node)->istype, 0, level, 1, off, NULL);
				   off+=1; 
			}
    break;

  case 72:
/* Line 1792 of yacc.c  */
#line 493 "lab9.y"
    {
            			(yyval.node)=ASTCreateNode(ARGLIST);
            			(yyval.node)->left=(yyvsp[(1) - (3)].node);
            			(yyval.node)->next=(yyvsp[(3) - (3)].node);
				(yyval.node)->istype=(yyvsp[(1) - (3)].node)->istype;//inheritence 
				(yyval.node)->name = CreateTemp();
				(yyval.node)->symbol=Insert((yyval.node)->name, (yyval.node)->istype, 0, level, 1, off, NULL);
				off+=1;
           		}
    break;


/* Line 1792 of yacc.c  */
#line 2241 "y.tab.c"
      default: break;
    }
  /* User semantic actions sometimes alter yychar, and that requires
     that yytoken be updated with the new translation.  We take the
     approach of translating immediately before every use of yytoken.
     One alternative is translating here after every semantic action,
     but that translation would be missed if the semantic action invokes
     YYABORT, YYACCEPT, or YYERROR immediately after altering yychar or
     if it invokes YYBACKUP.  In the case of YYABORT or YYACCEPT, an
     incorrect destructor might then be invoked immediately.  In the
     case of YYERROR or YYBACKUP, subsequent parser actions might lead
     to an incorrect destructor call or verbose syntax error message
     before the lookahead is translated.  */
  YY_SYMBOL_PRINT ("-> $$ =", yyr1[yyn], &yyval, &yyloc);

  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);

  *++yyvsp = yyval;

  /* Now `shift' the result of the reduction.  Determine what state
     that goes to, based on the state we popped back to and the rule
     number reduced by.  */

  yyn = yyr1[yyn];

  yystate = yypgoto[yyn - YYNTOKENS] + *yyssp;
  if (0 <= yystate && yystate <= YYLAST && yycheck[yystate] == *yyssp)
    yystate = yytable[yystate];
  else
    yystate = yydefgoto[yyn - YYNTOKENS];

  goto yynewstate;


/*------------------------------------.
| yyerrlab -- here on detecting error |
`------------------------------------*/
yyerrlab:
  /* Make sure we have latest lookahead translation.  See comments at
     user semantic actions for why this is necessary.  */
  yytoken = yychar == YYEMPTY ? YYEMPTY : YYTRANSLATE (yychar);

  /* If not already recovering from an error, report this error.  */
  if (!yyerrstatus)
    {
      ++yynerrs;
#if ! YYERROR_VERBOSE
      yyerror (YY_("syntax error"));
#else
# define YYSYNTAX_ERROR yysyntax_error (&yymsg_alloc, &yymsg, \
                                        yyssp, yytoken)
      {
        char const *yymsgp = YY_("syntax error");
        int yysyntax_error_status;
        yysyntax_error_status = YYSYNTAX_ERROR;
        if (yysyntax_error_status == 0)
          yymsgp = yymsg;
        else if (yysyntax_error_status == 1)
          {
            if (yymsg != yymsgbuf)
              YYSTACK_FREE (yymsg);
            yymsg = (char *) YYSTACK_ALLOC (yymsg_alloc);
            if (!yymsg)
              {
                yymsg = yymsgbuf;
                yymsg_alloc = sizeof yymsgbuf;
                yysyntax_error_status = 2;
              }
            else
              {
                yysyntax_error_status = YYSYNTAX_ERROR;
                yymsgp = yymsg;
              }
          }
        yyerror (yymsgp);
        if (yysyntax_error_status == 2)
          goto yyexhaustedlab;
      }
# undef YYSYNTAX_ERROR
#endif
    }



  if (yyerrstatus == 3)
    {
      /* If just tried and failed to reuse lookahead token after an
	 error, discard it.  */

      if (yychar <= YYEOF)
	{
	  /* Return failure if at end of input.  */
	  if (yychar == YYEOF)
	    YYABORT;
	}
      else
	{
	  yydestruct ("Error: discarding",
		      yytoken, &yylval);
	  yychar = YYEMPTY;
	}
    }

  /* Else will try to reuse lookahead token after shifting the error
     token.  */
  goto yyerrlab1;


/*---------------------------------------------------.
| yyerrorlab -- error raised explicitly by YYERROR.  |
`---------------------------------------------------*/
yyerrorlab:

  /* Pacify compilers like GCC when the user code never invokes
     YYERROR and the label yyerrorlab therefore never appears in user
     code.  */
  if (/*CONSTCOND*/ 0)
     goto yyerrorlab;

  /* Do not reclaim the symbols of the rule which action triggered
     this YYERROR.  */
  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);
  yystate = *yyssp;
  goto yyerrlab1;


/*-------------------------------------------------------------.
| yyerrlab1 -- common code for both syntax error and YYERROR.  |
`-------------------------------------------------------------*/
yyerrlab1:
  yyerrstatus = 3;	/* Each real token shifted decrements this.  */

  for (;;)
    {
      yyn = yypact[yystate];
      if (!yypact_value_is_default (yyn))
	{
	  yyn += YYTERROR;
	  if (0 <= yyn && yyn <= YYLAST && yycheck[yyn] == YYTERROR)
	    {
	      yyn = yytable[yyn];
	      if (0 < yyn)
		break;
	    }
	}

      /* Pop the current state because it cannot handle the error token.  */
      if (yyssp == yyss)
	YYABORT;


      yydestruct ("Error: popping",
		  yystos[yystate], yyvsp);
      YYPOPSTACK (1);
      yystate = *yyssp;
      YY_STACK_PRINT (yyss, yyssp);
    }

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END


  /* Shift the error token.  */
  YY_SYMBOL_PRINT ("Shifting", yystos[yyn], yyvsp, yylsp);

  yystate = yyn;
  goto yynewstate;


/*-------------------------------------.
| yyacceptlab -- YYACCEPT comes here.  |
`-------------------------------------*/
yyacceptlab:
  yyresult = 0;
  goto yyreturn;

/*-----------------------------------.
| yyabortlab -- YYABORT comes here.  |
`-----------------------------------*/
yyabortlab:
  yyresult = 1;
  goto yyreturn;

#if !defined yyoverflow || YYERROR_VERBOSE
/*-------------------------------------------------.
| yyexhaustedlab -- memory exhaustion comes here.  |
`-------------------------------------------------*/
yyexhaustedlab:
  yyerror (YY_("memory exhausted"));
  yyresult = 2;
  /* Fall through.  */
#endif

yyreturn:
  if (yychar != YYEMPTY)
    {
      /* Make sure we have latest lookahead translation.  See comments at
         user semantic actions for why this is necessary.  */
      yytoken = YYTRANSLATE (yychar);
      yydestruct ("Cleanup: discarding lookahead",
                  yytoken, &yylval);
    }
  /* Do not reclaim the symbols of the rule which action triggered
     this YYABORT or YYACCEPT.  */
  YYPOPSTACK (yylen);
  YY_STACK_PRINT (yyss, yyssp);
  while (yyssp != yyss)
    {
      yydestruct ("Cleanup: popping",
		  yystos[*yyssp], yyvsp);
      YYPOPSTACK (1);
    }
#ifndef yyoverflow
  if (yyss != yyssa)
    YYSTACK_FREE (yyss);
#endif
#if YYERROR_VERBOSE
  if (yymsg != yymsgbuf)
    YYSTACK_FREE (yymsg);
#endif
  /* Make sure YYID is used.  */
  return YYID (yyresult);
}


/* Line 2055 of yacc.c  */
#line 508 "lab9.y"
 /*end rules */

int main(int argc, char *argv[])
{ //int i = 1;
  FILE *fp;
  
  
  
  if((strcmp(argv[1], "-d") == 0) && (strcmp(argv[2], "-o") == 0)){
		mydebug = 1;
		fp = fopen(argv[3], "w");
		yyparse();
		emitast(program,fp);
  }
  
  else if((strcmp(argv[1], "-o") == 0) && (strcmp(argv[3], "-d") == 0)){
		mydebug = 1;
		fp = fopen(argv[2], "w");
		yyparse();
		emitast(program,fp);
   }

   else if((strcmp(argv[1],"-o") == 0) && (strcmp(argv[3], "-d") == 1)){
		fp = fopen(argv[2], "w");
		yyparse();
	        emitast(program,fp);
   }
	
  //yyparse();
  //emitast(program,fp);
  //Display();
  //ASTprint(0,program);  /* this is where we can do things with the AST like print it or process it */
}
		
