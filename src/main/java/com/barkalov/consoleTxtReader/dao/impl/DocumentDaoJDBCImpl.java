package com.barkalov.consoleTxtReader.dao.impl;

import com.barkalov.consoleTxtReader.dao.DocumentDao;
import com.barkalov.consoleTxtReader.dao.queries.InsertDocumentLineQuery;
import com.barkalov.consoleTxtReader.dao.queries.InsertDocumentQuery;
import com.barkalov.consoleTxtReader.entity.Document;
import com.barkalov.consoleTxtReader.entity.DocumentLine;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("documentDao")
public class DocumentDaoJDBCImpl implements DocumentDao {

    private DataSource dataSource;
    private InsertDocumentLineQuery insertDocumentLineQuery;
    private InsertDocumentQuery insertDocumentQuery;

    public void insertDocumentWithLines(List<Document> documents) {
        insertDocumentLineQuery = new InsertDocumentLineQuery(dataSource);

        documents.stream().forEach(document -> {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("name", document.getName());
            paramMap.put("line_count", document.getLineCount());

            KeyHolder keyHolder = new GeneratedKeyHolder();
            insertDocumentQuery.updateByNamedParam(paramMap, keyHolder);
            document.setId(keyHolder.getKey().longValue());

            List<DocumentLine> documentLines = document.getDocumentLines();
            documentLines.stream().forEach(value -> {
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("line", value.getLine());
                param.put("document_id", value.getDocument().getId());
                param.put("length", value.getLength());
                param.put("longest_word", value.getLongestWord());
                param.put("shortest_word", value.getShortestWord());
                param.put("average", value.getAverage());

                KeyHolder keyId = new GeneratedKeyHolder();
                insertDocumentLineQuery.updateByNamedParam(param, keyId);
                value.setId(keyId.getKey().longValue());
                insertDocumentLineQuery.flush();
            });
        });

    }

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        insertDocumentQuery = new InsertDocumentQuery(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
