package db;

public class SQLQuery {


   public static final String CREATE_TABLE_ACCOUNT = "CREATE TABLE IF NOT EXISTS ACCOUNT (ID CHAR PRIMARY KEY, CREDENTIAL_ID CHAR, NUMBER CHAR, HOLDER CHAR, AMOUNT NUMBER(10,2));";
   public static final String CREATE_TABLE_CREDENTIAL = "CREATE TABLE IF NOT EXISTS CREDENTIAL(ID CHAR PRIMARY KEY, LOGIN CHAR, PASSWORD CHAR);";
   public static final String CREATE_TABLE_ATM = "CREATE TABLE IF NOT EXISTS ATM(ID CHAR PRIMARY KEY, NAME CHAR);";
   public static final String CREATE_ATM_VOLUME = "CREATE TABLE IF NOT EXISTS ATM_VOLUME (ID CHAR PRIMARY KEY, ATM_ID CHAR, RATE INTEGER, AMOUNT INTEGER);";
   public static final String SHOW_DB_META_DATA = "SELECT name, sql FROM sqlite_master WHERE type='table' ORDER BY name;";
   public static final String INSERT_ATM_DATA = "INSERT INTO ATM (ID, NAME) VALUES (?,?);";
   public static final String INSERT_ATM_VOLUME_DATA = "INSERT INTO ATM_VOLUME (ID, ATM_ID, RATE, AMOUNT) VALUES (?,?,?,?);";
   public static final String INSERT_CREDENTIAL_DATA = "INSERT INTO CREDENTIAL (ID, LOGIN, PASSWORD) VALUES (?,?,?);";
   public static final String INSERT_ACCOUNT_DATA = "INSERT INTO ACCOUNT (ID, CREDENTIAL_ID, NUMBER, HOLDER, AMOUNT) VALUES (?,?,?,?,?);";
   public static final String SELECT_ATM_DATA = "SELECT * FROM ATM;";
}
