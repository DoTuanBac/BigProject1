package Dictionary;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class listen {                 
    static public String Name="kevin16";
        static public void Speech(String str)
        {
            Voice voice;
            VoiceManager vm=VoiceManager.getInstance();
            voice=vm.getVoice(Name);
            voice.allocate();
            voice.speak(str);
        
        }
}
        
             