package ca.warp7.frc2022.lib;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class LazySolenoid {
    private Solenoid solenoid;
    private boolean enabled;
    private boolean on = false;

    public LazySolenoid(int channel, boolean enabled) {
        //enabled = true;
        this.enabled = enabled;
        if (enabled) {
            this.solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, channel);
        } else {
            // don't want to create it at all, since the compressor would
            // start when any solenoids are instantiated
            this.solenoid = null;
        }
    }

    public boolean get() {
        if (enabled) {
            return solenoid.get();
        } else {
            return on;
        }
    }

    public void set(boolean on) {
        if (on != this.on) {
            this.on = on;
            if (enabled) {
                solenoid.set(on);
            }
        }
    }

    public void toggle() {
        set(!get());
    }
}
