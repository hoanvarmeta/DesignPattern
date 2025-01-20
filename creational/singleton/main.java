package creational.singleton;

import java.util.ArrayList;

class Table {
    static int current = 0;
    int Id;
    String TableName;

    Table(String tableName) {
        this.TableName = tableName;
        this.Id = ++this.current;
    }

    public String getTableName() {
        return "Table: " + this.TableName;
    }
}

final class DataBase {
    private String name;
    private static DataBase instance;
    private ArrayList<Table> tables = new ArrayList<>();

    DataBase(String name) {
        if (instance != null) {
            this.name = name;
        }
    }

    public Table getTable(String tableName) {
        for (Table table : this.tables) {
            if (table.TableName.equals(tableName)) {
                return table;
            }
        }
        return null;
    }

    public boolean addTable(String tableName) {
        for (Table table : this.tables) {
            if (table.TableName.equals(tableName)) {
                return false;
            }
        }

        Table table = new Table(tableName);
        table.TableName = tableName;
        this.tables.add(table);

        return true;
    }

    public static DataBase getInstanceDB(String name) {
        if (instance == null) {
            instance = new DataBase(name);
        }
        return instance;
    }
}

public class main {

    public static void main(String[] args) {
        DataBase database = DataBase.getInstanceDB("DBDev");
        Table table = database.getTable("Users");
        if (table == null) {
            database.addTable("Users");
        }

        table = database.getTable("Users");
        System.out.println(table.getTableName());
    }

}
