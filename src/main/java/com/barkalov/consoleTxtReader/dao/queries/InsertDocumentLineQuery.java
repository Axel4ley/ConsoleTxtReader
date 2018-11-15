package com.barkalov.consoleTxtReader.dao.queries;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class InsertDocumentLineQuery extends BatchSqlUpdate {

    private static final String SQL_INSERT_DOCUMENT_LINE = "insert into document_line " +
            "(line, document_id, length, longest_word, shortest_word, average) " +
            "values (:line, :document_id, :length, :longest_word, :shortest_word, :average)";
    private static final int BATCH_SIZE = 10;

    public InsertDocumentLineQuery(DataSource dataSource) {
        super(dataSource, SQL_INSERT_DOCUMENT_LINE);

        declareParameter(new SqlParameter("line", Types.LONGVARCHAR));
        declareParameter(new SqlParameter("document_id", Types.INTEGER));
        declareParameter(new SqlParameter("length", Types.INTEGER));
        declareParameter(new SqlParameter("longest_word", Types.VARCHAR));
        declareParameter(new SqlParameter("shortest_word", Types.VARCHAR));
        declareParameter(new SqlParameter("average", Types.DOUBLE));

        setGeneratedKeysColumnNames(new String[]{"id"});
        setReturnGeneratedKeys(true);
        setBatchSize(BATCH_SIZE);
    }
}
