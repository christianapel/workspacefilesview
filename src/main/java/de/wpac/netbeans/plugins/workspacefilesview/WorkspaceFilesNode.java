package de.wpac.netbeans.plugins.workspacefilesview;

import java.awt.Image;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.Project;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.FilterNode;
import org.openide.util.ImageUtilities;

public class WorkspaceFilesNode extends FilterNode
{
  @StaticResource
  private static final String IMAGE = "de/wpac/netbeans/plugins/workspacefilesview/folder.png";
      
  public WorkspaceFilesNode(Project proj) throws DataObjectNotFoundException
  {
    super(DataObject.find(proj.getProjectDirectory()).getNodeDelegate());
  }

  @Override
  public boolean canCopy()
  {
    return false;
  }

  @Override
  public boolean canCut()
  {
    return false;
  }

  @Override
  public boolean canDestroy()
  {
    return false;
  }

  @Override
  public boolean canRename()
  {
    return false;
  }
  
  @Override
  public String getDisplayName()
  {
    return "Workspace View";
  }
  
  @Override
  public Image getIcon(int type)
  {
    DataFolder root = DataFolder.findFolder(FileUtil.getConfigRoot());
    Image original = root.getNodeDelegate().getIcon(type);
    return ImageUtilities.mergeImages(original,
            ImageUtilities.loadImage(IMAGE), 7, 7);
  }

  @Override
  public Image getOpenedIcon(int type)
  {
    DataFolder root = DataFolder.findFolder(FileUtil.getConfigRoot());
    Image original = root.getNodeDelegate().getIcon(type);
    return ImageUtilities.mergeImages(original,
            ImageUtilities.loadImage(IMAGE), 7, 7);
  }
}
