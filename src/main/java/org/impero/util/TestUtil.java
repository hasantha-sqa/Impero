package org.impero.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;

public class TestUtil
{
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;

    public static InputStream takeScreenshot( WebDriver driver ) throws IOException
    {
        File screenshot = ( ( TakesScreenshot ) driver ).getScreenshotAs( OutputType.FILE );
        BufferedImage bufferedImage = ImageIO.read( screenshot );

        byte[] image = null;
        try( ByteArrayOutputStream bos = new ByteArrayOutputStream() )
        {
            ImageIO.write( bufferedImage, "png", bos );
            image = bos.toByteArray();
        }
        catch( Exception ignored )
        {
        }

        return new ByteArrayInputStream( Objects.requireNonNull( image ) );
    }
}
