package test;

import org.junit.jupiter.api.Test;
import rule.Formation;
import rule.InitFormationSetting;

public class InitFormationSettingTest {

    InitFormationSetting initFormationSetting = new InitFormationSetting();

    @Test
    void makeFormation() {
        initFormationSetting.makeFormation(Formation.FIRST, Formation.FIRST);
        System.out.println(initFormationSetting);
    }
}
