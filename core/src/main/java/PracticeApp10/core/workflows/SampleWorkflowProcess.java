package PracticeApp10.core.workflows;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    service=WorkflowProcess.class,
    property = {"process.label=Sample Workflow 1"}
)
public class SampleWorkflowProcess implements WorkflowProcess {
    private static final Logger log = LoggerFactory.getLogger(SampleWorkflowProcess.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap args) throws WorkflowException {

        final WorkflowData workflowData = workItem.getWorkflowData();
        final String type = workflowData.getPayloadType();

        // Get the path to the JCR resource from the payload
        final String path = workflowData.getPayload().toString();

        String somethingImportant = args.get("somethingImportant", "not set");

        log.info("Sample Workflow 1 - somethingImportant: {} - payload: {}", somethingImportant, path);
    }
}
