package six_problems

import java.io.File

import scala.swing.{BoxPanel, Button, FileChooser, FlowPanel, Label, MainFrame, Orientation, ScrollPane, Swing, TextArea}

/**
  * Created by liuyufei on 18/02/17.
  *
  Write a GUI application which enables the user to select a folder. The application outputs the list of
  all files under this folder (and sub folders).
  */
class Prog2 extends MainFrame{

  title = "File selector"

  val fileChooser:FileChooser = new FileChooser()

  fileChooser.fileSelectionMode = FileChooser.SelectionMode.FilesAndDirectories

  fileChooser.descriptionFor(new File(System.getProperty("user.home")))

  val textArea = new TextArea(10,50){
    editable = false
  }

  val scrollPane = new ScrollPane(textArea)

  val buttonPanel = new FlowPanel{
    contents += Button("Close"){
      System.exit(0)
    }
    contents += Button("click") {
      selectFile()
    }
  }

  val mainPanel = new BoxPanel(Orientation.Vertical) {
    contents += new Label("File Path")
    contents += scrollPane
    contents += buttonPanel
    border = Swing.EmptyBorder(30, 10, 10, 10)
  }

  contents = mainPanel

  def selectFile(): Unit = {
    fileChooser.showOpenDialog(mainPanel) match {
      case FileChooser.Result.Approve => listFileNames(fileChooser.selectedFile)
      case _ => println("other action!!")
    }
  }

  def listFileNames(file:File) = {
    val fileNames = file.listFiles().map(_.getAbsolutePath).mkString("\n")
    textArea.text = fileNames
    repaint()
  }

}

object Main extends App{
  val selector = new Prog2
  selector.visible = true
}
