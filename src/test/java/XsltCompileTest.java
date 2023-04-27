import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.transform.Templates;

public class XsltCompileTest {

    @Test
    public void shouldCompileXslt() throws TransformerConfigurationException, MalformedURLException {
        URL xsltFileUrl = new URL("file:src/test/resources/file.xslt");
        TransformerFactory tFactory = TransformerFactory.newInstance();
        StreamSource streamSource = new StreamSource(xsltFileUrl.toExternalForm());

        // this used to break during native-tests
        final Templates templates = tFactory.newTemplates(streamSource);
        // this now breaks during native-tests
        templates.newTransformer();
    }

    @Test
    public void shouldNotFindFile() throws MalformedURLException {
        URL xsltFileUrl = new URL("file:wrong/path");
        TransformerFactory tFactory = TransformerFactory.newInstance();
        StreamSource streamSource = new StreamSource(xsltFileUrl.toExternalForm());

        Assertions.assertThrows(TransformerConfigurationException.class, () ->
                tFactory.newTemplates(streamSource));
    }
}
