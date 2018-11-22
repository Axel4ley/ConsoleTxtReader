package com.barkalov.consoleTxtReader;

import com.barkalov.consoleTxtReader.entity.Document;
import com.barkalov.consoleTxtReader.service.DocumentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class DocumentServiceTest {
    DocumentService documentService;
    private static final String TEST_DATA_DIRECTORY = "data";
    private static final String TEST_DATA_SUB_DIRECTORY = "data/sub-directory";

    @Test
    public void getDocumentWithStatisticIntegrationTest() {
        List<Document> documents = documentService.getDocumentsWithStatistic(TEST_DATA_SUB_DIRECTORY);
        Assert.assertEquals(2, documents.size());

        Document document = documents.get(0);
        Assert.assertEquals("third-article.txt", document.getName());
//        Assert.assertEquals(3, document.getDocumentLines().size());
//        Assert.assertEquals("There are a few some words in the document.", document.getDocumentLines().get(0).getLine());
//        Assert.assertEquals("a", document.getDocumentLines().get(0).getShortestWord());
//        Assert.assertEquals("document", document.getDocumentLines().get(0).getLongestWord());
//        Assert.assertEquals(new Integer(9), document.getDocumentLines().get(0).getLength());
//        Assert.assertEquals(new Double(3.7777777777777777), new Double(document.getDocumentLines().get(0).getAverage()));
    }

    @Resource(name = "documentService")
    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
}
