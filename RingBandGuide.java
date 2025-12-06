package data.scripts;

import java.awt.Color;
import com.fs.starfarer.api.campaign.PlanetAPI;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.impl.campaign.ids.Terrain;

/**
 * ============================================================================
 * GUIDE: CREATING CUSTOM RING BANDS IN STARSECTOR
 * ============================================================================
 * * This reference class explains how to use the `system.addRingBand(...)` method.
 * You can copy the code blocks below into your own system generation scripts.
 */
public class RingBandGuide {

    // This method is just for demonstration. You would put this code inside your 'generate' method.
    public void examples(StarSystemAPI system, PlanetAPI star) {

        /* * --------------------------------------------------------------------
         * 1. THE METHOD SIGNATURE
         * --------------------------------------------------------------------
         * system.addRingBand(
         * focusEntity,    // The object the ring orbits (Star or Planet)
         * "category",     // Usually "misc"
         * "textureId",    // The image texture ID from settings.json
         * 256f,           // Band width in texture pixels (usually 256f)
         * index,          // Which band index to use (0, 1, 2, 3)
         * color,          // The tint color of the ring
         * bandWidth,      // How wide the ring actually is in-game (Map Units)
         * middleRadius,   // How far from the center the ring sits (Map Units)
         * orbitDays,      // How fast it spins (Lower = Faster)
         * terrainId,      // Usually Terrain.RING
         * "Ring Name"     // The name that appears on the map (Optional, can be null)
         * );
         */

        // --------------------------------------------------------------------
        // 2. TEXTURE OPTIONS
        // --------------------------------------------------------------------
        // "rings_dust0"    -> Rocky, dusty look (Good for asteroids/debris)
        // "rings_ice0"     -> Shiny, smooth look (Good for ice rings or halos)
        // "rings_special0" -> Unique patterns (Good for exotic effects)

        
        // --------------------------------------------------------------------
        // 3. EXAMPLE PRESETS
        // --------------------------------------------------------------------

        // EXAMPLE A: "The Shredder" (Fast, Dark, jagged Dust)
        system.addRingBand(
            star,                       // Focus
            "misc",                     // Category
            "rings_dust0",              // Texture
            256f,                       // Texture Width
            3,                          // Index 3 (Jagged look)
            new Color(50, 50, 60, 255), // Dark Grey Color
            256f,                       // Width in Game
            3000f,                      // Radius
            30f,                        // Orbit Days (Fast!)
            Terrain.RING,               // Terrain ID
            "The Shredder"              // Name
        );

        // EXAMPLE B: "Ion Halo" (Glowing, Transparent Ice)
        system.addRingBand(
            star, 
            "misc", 
            "rings_ice0",               // Ice Texture
            256f, 
            2,                          // Index 2 (Smooth look)
            new Color(0, 255, 255, 150),// Cyan with 150 Alpha (Transparent)
            512f,                       // Wider Band
            5000f,                      // Radius
            60f,                        // Medium Speed
            Terrain.RING, 
            "Ion Halo"
        );

        // EXAMPLE C: "Deep Space Dust" (Faint, massive outer ring)
        system.addRingBand(
            star, 
            "misc", 
            "rings_dust0", 
            256f, 
            0,                          // Index 0 (Wispy look)
            new Color(100, 100, 255, 50), // Very Faint Blue
            1000f,                      // Massive Width
            10000f,                     // Far Radius
            200f,                       // Slow Speed
            Terrain.RING, 
            "Outer Dust"
        );

        /*
         * --------------------------------------------------------------------
         * 4. ADDING PHYSICAL ASTEROIDS
         * --------------------------------------------------------------------
         * Rings are visual only. To make ships crash, add an asteroid belt 
         * at the SAME radius.
         */
        
        // Adds 250 asteroids at radius 3000 (Matching "The Shredder" above)
        system.addAsteroidBelt(
            star, 
            250,   // Number of rocks
            3000f, // Orbit Radius (Must match the RingBand radius)
            256f,  // Width
            30f,   // Min Orbit Days
            50f,   // Max Orbit Days
            Terrain.ASTEROID_BELT, 
            "The Shredder"
        );
    }
}