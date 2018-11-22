package com.barkalov.consoleTxtReader;

import com.barkalov.consoleTxtReader.dao.DocumentDao;
import com.barkalov.consoleTxtReader.entity.Document;
import com.barkalov.consoleTxtReader.service.DocumentServiceImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class Application {
    private static final String DIRECTORY_URL = "/home/vova/workspace/ConsoleTxtReader/data";
    private static final String CONTEXT_URL = "classpath:console-context.xml";

    public static void main(String args[]) {
        setUp(DIRECTORY_URL);
    }

    public static void setUp(String directoryUrl) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(CONTEXT_URL);
        context.refresh();

        DocumentServiceImpl documentServiceImpl = context.getBean("documentService", DocumentServiceImpl.class);
        DocumentDao documentDao = context.getBean("documentDao", DocumentDao.class);

        List<Document> documents = documentServiceImpl.getDocumentsWithStatistic(directoryUrl);
        if (!documents.isEmpty()) {
            documentDao.insertDocumentWithLines(documents);
        }
    }
}
