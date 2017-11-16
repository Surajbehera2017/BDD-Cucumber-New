package common;

import static steps.Moderator.sce;

import core.Logger;

public class Log implements Logger
{
    public void info(String log)
    {
    	String t="INFO : [ "+log+" ]";
        sce.write(t);
        System.out.println(t);
    }

    public void warn(String log)
    {
    	String t="WARNING : [ "+log+" ]";
    	sce.write(t);
        System.out.println(t);
    }

    public void error(String log)
    {
    	String t="ERROR : [ "+log+" ]";
    	sce.write(t);
        System.out.println(t);
    }
}
