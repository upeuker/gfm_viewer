package code.satyagraha.gfm.support.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharEncoding;

import code.satyagraha.gfm.support.api.GfmConfig;

public class GfmConfigDefault implements GfmConfig {

    private static final String API_ROOT_URL = "https://api.github.com";
    private static final Charset UTF_8 = Charset.forName(CharEncoding.UTF_8);
    
    /* (non-Javadoc)
     * @see code.satyagraha.gfm.support.GfmConfig#getApiUri()
     */
    @Override
    public String getApiUrl() {
      return API_ROOT_URL;
    }

    /* (non-Javadoc)
     * @see code.satyagraha.gfm.support.api.GfmConfig#getUsername()
     */
    @Override
    public String getUsername() {
        return null;
    }
    
    /* (non-Javadoc)
     * @see code.satyagraha.gfm.support.api.GfmConfig#getPassword()
     */
    @Override
    public String getPassword() {
        return null;
    }
    
    /* (non-Javadoc)
     * @see code.satyagraha.gfm.support.GfmConfig#getHtmlTemplate()
     */
    @Override
    public String getHtmlTemplate() throws IOException {
        String htmlTemplateText = getResourceAsString("MDTemplate.html");
        return htmlTemplateText;
    }

    /* (non-Javadoc)
     * @see code.satyagraha.gfm.support.GfmConfig#getCssText()
     */
    @Override
    public String getCssText() throws IOException {
        String cssText = getResourceAsString("MDStyle.css");
        return cssText;
    }

    /* (non-Javadoc)
     * @see code.satyagraha.gfm.support.GfmConfig#getCssUris()
     */
    @Override
    public List<String> getCssUris() {
        return Arrays.asList();
    }

    /* (non-Javadoc)
     * @see code.satyagraha.gfm.support.api.GfmConfig#getJsText()
     */
    @Override
    public String getJsText() throws IOException {
        String jsText = getResourceAsString("MDScript.js");
        return jsText;
    }
    
    /* (non-Javadoc)
     * @see code.satyagraha.gfm.support.api.GfmConfig#getJsUris()
     */
    @Override
    public List<String> getJsUris() {
        return Arrays.asList();
    }

    /* (non-Javadoc)
     * @see code.satyagraha.gfm.support.api.GfmConfig#useTempDir()
     */
    @Override
    public boolean useTempDir() {
        return false;
    }
    
    private String getResourceAsString(String resourcePath) throws IOException {
        InputStream templateStream = GfmConfigDefault.class.getResourceAsStream(resourcePath);
        if (templateStream == null) {
            throw new FileNotFoundException(resourcePath);
        }
        String htmlTemplateText = IOUtils.toString(templateStream, UTF_8);
        IOUtils.closeQuietly(templateStream);
        return htmlTemplateText;
    }
    
}
