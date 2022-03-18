package com.yungnickyoung.minecraft.yungsextras.module;

import java.util.ArrayList;
import java.util.List;

public class ConfigModule {
    public final DesertDecorations desert = new DesertDecorations();
    public final SwampStructures swamp = new SwampStructures();

    public static class DesertDecorations {
        public Wells wells = new Wells();
        public Obelisks obelisks = new Obelisks();
        public Misc misc = new Misc();
        public List<String> additionalBiomeWhitelist = new ArrayList<>();
        public List<String> biomeBlacklist = new ArrayList<>();

        public static class Wells {
            public int smallNormalWellSpawnRate = 1200;
            public int mediumNormalWellSpawnRate = 1200;
            public int largeNormalWellSpawnRate = 1200;
            public int smallWishingWellSpawnRate = 1200;
            public int mediumWishingWellSpawnRate = 1200;
            public int largeWishingWellSpawnRate = 1200;
            public int smallDryWellSpawnRate = 1200;
            public int mediumDryWellSpawnRate = 1200;
            public int largeDryWellSpawnRate = 1200;
        }

        public static class Obelisks {
            public int normalObeliskSpawnRate = 700;
            public int creeperObeliskSpawnRate = 700;
            public int ruinedObeliskSpawnRate = 700;
            public int blackstoneObeliskSpawnRate = 3000;
        }

        public static class Misc {
            public int smallRuinsSpawnRate = 1000;
            public int giantTorchSpawnRate = 700;
            public int chillzoneSpawnRate = 1000;
        }
    }

    public static class SwampStructures {
        public List<String> additionalBiomeWhitelist = new ArrayList<>();
        public List<String> biomeBlacklist = new ArrayList<>();

        public int pillarSpawnRate = 900;
        public int ogreSpawnRate = 3000;
        public int cubbySpawnRate = 1000;
        public int archSpawnRate = 1200;
        public int doubleArchSpawnRate = 1200;
        public int churchSpawnRate = 2000;
    }
}
