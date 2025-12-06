# Starsector Modding Guide: Creating Custom Ring Bands

This reference guide explains how to use the `system.addRingBand(...)` method in your sector generation scripts (e.g., `Seraphina.java`).

---

## 1. The Method Signature

To add a visual ring to a planet or star, you call this function inside your `generate()` method:

```java
system.addRingBand(
    focusEntity,    // The object the ring orbits (Star or Planet)
    "category",     // Usually "misc"
    "textureId",    // The image texture ID (defined in settings.json)
    256f,           // Band width in texture pixels (Standard: 256f)
    index,          // Which band pattern to use (0, 1, 2, or 3)
    color,          // The tint color of the ring
    bandWidth,      // The visual width of the ring in-game (Map Units)
    middleRadius,   // Distance from the center entity
    orbitDays,      // Rotation speed (Lower number = Faster spin)
    terrainId,      // Usually Terrain.RING
    "Ring Name"     // Name shown on map (can be null)
);
