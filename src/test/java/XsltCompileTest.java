import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.net.MalformedURLException;
import java.net.URL;

public class XsltCompileTest {

    @Test
    public void shouldCompileXslt() throws TransformerConfigurationException, MalformedURLException {
        URL xsltFileUrl = new URL("file:src/test/resources/file.xslt");
        TransformerFactory tFactory = TransformerFactory.newInstance();
        StreamSource streamSource = new StreamSource(xsltFileUrl.toExternalForm());

        // this breaks during native-tests
        tFactory.newTemplates(streamSource);
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
