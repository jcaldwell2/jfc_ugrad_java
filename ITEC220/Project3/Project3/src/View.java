/**
 * The type View handles the GUI elements.
 * @author James Caldwell
 * @version April 6th
 */
public class View {


    /**
     * Instantiates a new View.
     */
    public View(){


       getYesNoDialog();

   }

    /**
     * Get yes no dialog.
     */
    public static  void getYesNoDialog(){

        YesNoDialog dialog = new YesNoDialog();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);




    }

    /**
     * Get LoadPos Window
     */
    public static  void getLoadPoS(){

       LoadPos dialog2 = new LoadPos();
       dialog2.pack();
       dialog2.setLocationRelativeTo(null);
       dialog2.setVisible(true);
    }

    /**
     * Get concentration dialog.
     */
    public static   void getConcenDialog(){

      Concentration dialog3 = new Concentration();
      dialog3.pack();
      dialog3.setLocationRelativeTo(null);
      dialog3.setVisible(true);
    }

    /**
     * Get main dialog.
     *
     * @param pos the pos
     */
    public static void getMainDialog(ProgramOfStudy pos){

        MainWindow dialog4 = new MainWindow(pos);
        dialog4.pack();
        dialog4.setLocationRelativeTo(null);
        dialog4.setVisible(true);

    }

    /**
     * Get save dialog.
     *
     * @param pos the pos
     */
    public static  void getSaveDialog(ProgramOfStudy pos){

        SaveDialog dialog5 = new SaveDialog(pos);
        dialog5.pack();
        dialog5.setLocationRelativeTo(null);
        dialog5.setVisible(true);
    }

    /**
     * Get course dialog.
     *
     * @param pos the pos
     */
    public static  void getCourseDialog(ProgramOfStudy pos){

        CourseDialog dialog6 = new CourseDialog(pos);
        dialog6.pack();
        dialog6.setLocationRelativeTo(null);
        dialog6.setVisible(true);
    }


}
