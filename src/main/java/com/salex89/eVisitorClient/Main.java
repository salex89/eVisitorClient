package com.salex89.eVisitorClient;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

/**
 * Created by aleksandar on 5/23/16.
 */
public class Main {

    public static void main(String[] args) {
        JCommanderContainer jct = new JCommanderContainer();
        try {
            new JCommander(jct, args);
            CommandBuilder builder = new CommandBuilder();
            CommandExecutor executor = builder.buildCommand(jct);
            executor.execute();
        } catch (ParameterException pe) {
            new JCommander(jct).usage();
        } catch (CallNotSupportedOperation e) {
            System.out.println("Operation " + e.getOperation() + " not supported");
            System.exit(1);
        } catch (InputFileError e) {
            System.out.println("Input file cannot be read");
            System.exit(2);
        }
        catch (OutputFileError e) {
            System.out.println("Output file cannot be written to");
            System.exit(3);
        }

    }

}
