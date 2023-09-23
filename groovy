import java.util.Properties;
import java.io.InputStream;
import com.boomi.execution.ExecutionUtil;
	
// Import the ExecutionUtil class


logger = ExecutionUtil.getBaseLogger();

def xml=new XmlSlurper().parse(ExecutionUtil.getDynamicProcessProperty("CONFIG_FILE_PATH")) ;

logger.info("Processing file : " +ExecutionUtil.getDynamicProcessProperty("CONFIG_FILE_PATH"));

    xml.'*'.depthFirst().each { node ->
       
       // logger.info( "-------------"+node.name()+" : "+node.text());
        ExecutionUtil.setDynamicProcessProperty(node.name(), node.text(),false);
        
      // ExecutionUtil.getDynamicProcessProperty("DB_Connection_URL")
        logger.info( ExecutionUtil.getDynamicProcessProperty(node.name()));
        
    }


