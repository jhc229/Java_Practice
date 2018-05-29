package cs2114.demos.temperatures;

import sofia.app.Screen;
import sofia.app.ScreenLayout;

public class TemperatureHelp extends Screen
{
    public void initialize()
    {

    }

    public void converterClicked()
    {
       presentScreen(TemperatureScreen.class);
       finish();
    }
}
