package de.wpac.netbeans.plugins.workspacefilesview;

import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.loaders.DataObjectNotFoundException;

@NodeFactory.Registration(projectType =
{
  "org-netbeans-modules-ant-freeform",
  "org-netbeans-modules-apisupport-project",
  "org-netbeans-modules-apisupport-project-suite",
  "org-netbeans-modules-apisupport-project-suite-jnlp",
  "org-netbeans-modules-apisupport-project-suite-osgi",
  "org-netbeans-modules-apisupport-project-suite-package",
  "org-netbeans-modules-autoproject",
  "org-netbeans-modules-bpel-project",
  "org-netbeans-modules-j2ee-clientproject",
  "org-netbeans-modules-j2ee-earproject",
  "org-netbeans-modules-j2ee-ejbjarproject",
  "org-netbeans-modules-java-j2seproject",
  "org-netbeans-modules-javacard-project",
  "org-netbeans-modules-javaee-project",
  "org-netbeans-modules-javafx2-project",
  "org-netbeans-modules-maven",
  "org-netbeans-modules-php-project",
  "org-netbeans-modules-ruby-project",
  "org-netbeans-modules-sql-project",
  "org-netbeans-modules-web-project",
  "org-netbeans-modules-xslt-project"
})

public class WorkspaceFilesNodeFactory implements NodeFactory
{
  @Override
  public NodeList createNodes(Project project)
  { 
    try 
    {
      WorkspaceFilesNode nd = new WorkspaceFilesNode(project);
      return NodeFactorySupport.fixedNodeList(nd);
    } 
    catch (DataObjectNotFoundException ex) 
    {
      //ex.printStackTrace();
    }
    
    return NodeFactorySupport.fixedNodeList();
  }
}
