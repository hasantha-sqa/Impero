package org.impero.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class JsonDataProvider
{
    @DataProvider( name = "GoogleSearch" )
    public Object[] getKeywords()
    {
        JsonArray jsonArray = null;

        try( FileReader reader = new FileReader( "src/main/resources/data/GoogleSearch.json" ) )
        {
            jsonArray = JsonParser.parseReader( reader ).getAsJsonArray();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }

        Object[] data = new Object[Objects.requireNonNull( jsonArray ).size()];

        for( int i = 0; i < jsonArray.size(); i++ )
        {
            data[i] = jsonArray.get( i ).getAsJsonObject();
        }

        return data;
    }
}
