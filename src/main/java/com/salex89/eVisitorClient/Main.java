package com.salex89.eVisitorClient;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.salex89.eVisitorClient.operations.OperationNotSupported;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by aleksandar on 5/23/16.
 */
public class Main {
    private static final String RESOURCE_URL_PROP = "resourceUrl";
    private static final String AUTH_URL_PROP = "authUrl";

    public static void main(String[] args) {
        JCommanderContainer jct = new JCommanderContainer();
        try {
            Properties properties = loadProperties();
            new JCommander(jct, args);
            String resourceUrl = loadResourceUrl(properties);
            String authUrl = loadAuthUrl(properties);
            CommandBuilder builder = new CommandBuilder(resourceUrl, authUrl);
            CommandExecutor executor = builder.buildCommand(jct);
            executor.execute();
        } catch (ParameterException pe) {
            new JCommander(jct).usage();
        } catch (OperationNotSupported e) {
            System.out.println("Operation " + e.getOperation() + " not supported");
            System.exit(1);
        } catch (InputFileError e) {
            System.out.println("Input file cannot be read");
            System.exit(2);
        } catch (OutputFileError e) {
            System.out.println("Output file cannot be written to");
            System.exit(3);
        } catch (PropertiesFileMissingException e) {
            System.out.println("application.properties missing");
            System.exit(4);
        }
    }

    private static String loadAuthUrl(Properties properties) {
        return properties.getProperty(AUTH_URL_PROP);
    }

    private static String loadResourceUrl(Properties properties) {
        return properties.getProperty(RESOURCE_URL_PROP);
    }

    public static Properties loadProperties() {

        File jarPath = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String propertiesPath = jarPath.getParentFile().getAbsolutePath();
        File propertiesFile = new File(propertiesPath + File.separator + "application.properties");
        Properties props = new Properties();
        if (propertiesFile.exists()) {
            InputStream is = null;
            try {
                is = new FileInputStream(propertiesFile);
                props.load(is);
            } catch (IOException e) {
                throw new PropertiesFileException(e);
            } finally {
                closePropFileStream(is);
            }
        } else {
            System.out.println("application.properties file not found, falling back to default");
            props.put("resourceUrl", "https://www.evisitor.hr/testApi/Rest/");
            props.put("authUrl", "https://www.evisitor.hr/testApi/Resources/AspNetFormsAuth/Authentication/");
        }
        return props;
    }

    private static void closePropFileStream(InputStream is) {
        try {
            is.close();
        } catch (IOException e) {
            throw new PropertiesFileException(e);
        }
    }


}

