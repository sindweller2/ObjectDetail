package submission.objectdetail;

import java.util.ArrayList;

public class ObjectData {
    public static String[][] data = new String[][]{
            {"Dante", "Legendary Devil Hunter","Gender : Male","Status : Alive", "https://vignette.wikia.nocookie.net/devilmaycry/images/a/aa/DMC5_Dante_Face.jpg","He is the second son of the demon Sparda and the human Eva, and the younger twin brother of Vergil. Dante is a paranormal mercenary, private investigator and vigilante Devil Hunter dedicated to exterminating evil demons and other malevolent supernatural forces; a mission he follows in pursuit of those that killed his mother and corrupted his brother."},
            {"Vergil", "Dark Slayer","Gender : Male","Status : Alive",  "https://vignette.wikia.nocookie.net/devilmaycry/images/7/74/Vergil_face_render_DMC5.png","Vergil is the eldest of twin sons born of the demon Sparda and human Eva. Following the death of their mother as children, Vergil and Dante go their separate ways, with Vergil rejecting his humanity and embracing his demonic heritage, contrasting his younger brother's embrace of humanity and initial rejection of the demonic. Stoic and reserved, Vergil displays a willingness to do anything in his quest to obtain the power of his father, Sparda."},
            {"Nero", "Devil Hunter","Gender : Male","Status : Alive", "https://vignette.wikia.nocookie.net/devilmaycry/images/7/76/Nero%27s_Face_Devil_May_Cry_5.jpg","He is the son of Vergil who is raised in Fortuna and serves as a Holy Knight in the Order of the Sword, a religious group that worships Sparda and fights to protect the world from demons. He is forced to fight against the Order after encountering Dante and uncovering a conspiracy to conquer the world using The Savior. Nero is a more seasoned demon hunter that has since changed his operation to being a mobile Devil May Cry branch. He finds himself fending off a demonic invasion as he chases a mysterious figure (later revealed to be his own biological father Vergil at the end) that severed the Devil Bringer. Eventually, Nero takes his uncle Dante's place as mankind's new protector."},
            {"V", "Mysterious One","Gender : Male","Status : Inactive", "https://vignette.wikia.nocookie.net/devilmaycry/images/1/1e/VFACE.png","A human with demonic ties, V presents himself as Dante's new client to put him on the trail of Urizen. It's revealed later that V is, in fact, the human half of Vergil's soul: the embodiment of his remorse and wisdom."},
            {"Trish", "Bewitching Devil", "Gender : Female","Status : Alive", "https://vignette.wikia.nocookie.net/devilmaycry/images/2/2a/TrishFace.png","Trish is a demon created by Mundus who strangely resembles Dante's mother, Eva. After his defeat by the hands of Dante, she later joined Devil May Cry and became a devil hunter alongside him. During her stint within the Order of the Sword, she went under the alias \"Gloria\"."},
            {"Lady", "Walking Arsenal","Gender : Female","Status : Alive", "https://vignette.wikia.nocookie.net/devilmaycry/images/c/c5/LadyFace.png","Lady is a human Devil Hunter. She is the daughter of Arkham and sought to hunt him down, encountering Dante in the process. While her preferred name, \"Lady\", was given to her by Dante, her birth name is Mary."},
            {"Nico", "Artisan of Arms","Gender : Female","Status : Alive", "https://vignette.wikia.nocookie.net/devilmaycry/images/4/49/DMC5_NicoFace.png","Nico is an expert craftswoman. She is an associate of Nero's branch of the Devil May Cry business as well as the mind behind the various cybernetic prosthetics he wields to hunt demons after the Devil Bringer was severed from his arm."}
    };

    public static ArrayList<ObjectModel> getData(){
        ObjectModel objectModel = null;
        ArrayList<ObjectModel> list = new ArrayList<>();
        for (String[] Data : data) {
            objectModel = new ObjectModel();
            objectModel.setName(Data[0]);
            objectModel.setRemark(Data[1]);
            objectModel.setGender(Data[2]);
            objectModel.setStatus(Data[3]);
            objectModel.setPicture(Data[4]);
            objectModel.setDescription(Data[5]);
            list.add(objectModel);
        }

        return list;
    }
}
