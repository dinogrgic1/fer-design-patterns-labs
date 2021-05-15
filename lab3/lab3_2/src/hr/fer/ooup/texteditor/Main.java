package hr.fer.ooup.texteditor;

public class Main {

    public static void main(String[] args) {
        String show = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse a tincidunt leo, sit amet ultricies metus. Ut rhoncus velit non auctor eleifend. Donec semper libero eu diam viverra molestie. Pellentesque pharetra vel massa sed tristique. Proin rutrum nisi metus, vel facilisis velit consequat non. Aliquam imperdiet aliquet nulla, non interdum massa vulputate eu. Sed mattis bibendum fermentum. Integer ligula turpis, facilisis non iaculis eget, fermentum nec augue.\n" +
                "\n" +
                "Nulla feugiat commodo lobortis. Donec feugiat nisi ac elit tristique, ut ultricies ante pellentesque. Sed commodo gravida magna. Nulla odio neque, dictum a convallis vel, commodo eget tortor. Sed suscipit metus sed erat pharetra accumsan. Vestibulum congue suscipit arcu. Donec faucibus, eros non posuere ullamcorper, mauris arcu accumsan risus, a porta mi mi sit amet tortor. Nam ut neque ac augue porttitor dapibus id ac augue. Nulla aliquet posuere neque, rutrum ullamcorper metus suscipit et. Nam iaculis ornare justo, id rhoncus tellus bibendum quis. Maecenas cursus felis vitae sapien ornare feugiat. Etiam augue lorem, hendrerit at scelerisque sed, posuere auctor purus. Morbi in commodo urna. Morbi ut diam et erat tempor cursus commodo in dui.\n" +
                "\n" +
                "Vivamus faucibus gravida nisl. Aenean lacinia ante ut odio porttitor ultrices ac sed ex. Duis finibus metus porttitor, condimentum lectus eget, vehicula lectus. Aliquam varius dapibus sem quis finibus. Ut turpis magna, auctor in scelerisque nec, sollicitudin sed quam. Vivamus efficitur congue felis, vitae aliquam eros mattis lobortis. Suspendisse consequat lacinia erat, vitae rutrum leo vulputate at. Maecenas eget mauris vitae nunc feugiat dapibus et in magna. Donec venenatis augue nulla, eget luctus mauris gravida efficitur. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Ut elementum tincidunt euismod. Integer magna massa, facilisis facilisis tellus id, tincidunt pretium lorem. Suspendisse non mattis metus.\n" +
                "\n" +
                "Nullam egestas, sem eget accumsan faucibus, diam lacus convallis turpis, eget euismod arcu nunc id quam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce a ex erat. Pellentesque a lorem sit amet metus bibendum viverra. Vestibulum at efficitur sapien. Aenean suscipit odio quis metus maximus, vel venenatis eros placerat. Praesent ut suscipit quam, at accumsan magna. Maecenas tempus quis risus vel pellentesque. Nulla facilisi. Nam at bibendum diam.\n" +
                "\n" +
                "Proin purus dui, vestibulum sit amet enim sed, ultricies congue augue. Nulla sed arcu vestibulum eros vestibulum efficitur. Nullam iaculis aliquet elit, nec aliquet tellus accumsan et. Cras eu enim vestibulum, dignissim dolor ut, ullamcorper est. Cras quis commodo nisi. Pellentesque convallis in tortor non convallis. Pellentesque id ex sed justo consequat mollis auctor non elit. Morbi a elit sit amet nulla tempor mattis. Phasellus scelerisque pretium ipsum a accumsan. Integer dignissim sapien in urna sollicitudin vulputate.";
        TextEditor te = new TextEditor("Text editor", new TextEditorModel(show));
        EditorCanvas ec = new EditorCanvas();
        te.add(ec);
        while (true) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            te.repaint();
        }
    }
}
