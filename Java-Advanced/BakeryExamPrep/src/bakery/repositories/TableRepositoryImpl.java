package bakery.repositories;

import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;

public class TableRepositoryImpl<T> implements TableRepository<Table> {
    Collection<Table> tables;

    public TableRepositoryImpl() {
        tables = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAll() {
        return tables;
    }

    @Override
    public void add(Table table) {
        tables.add(table);
    }

    @Override
    public Table getByNumber(int number) {
        Table tableToRet=null;
        for (Table table : tables) {
            if (table.getTableNumber()==number){
                tableToRet=table;
                break;
            }
        }
        return tableToRet;
    }
}
