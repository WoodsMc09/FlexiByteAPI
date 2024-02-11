package dev.flexibyte.flexibyteapi.libraries;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.data.BlockData;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ParticleLibrary {
    private Plugin plugin = null;

    public ParticleLibrary(Plugin plugin){
        this.plugin = plugin;
    }

    public void createDampeningRadialWaves(Location loc, Particle p, int count, int thetaIncrease, float amplitude, int duration){
        //create runnable
        new BukkitRunnable(){
            double t = 0; //time variable (radius proportional)
            /*
            thetaIncrease: bigger number = more particles/circle (divisible by 8)
            amplitude: bigger the number = higher the particles
             */

            @Override
            public void run() {
                t = t + 0.1*Math.PI;
                for (double theta = 0; theta < 2*Math.PI; theta = theta + Math.PI/thetaIncrease){
                    double x = t*Math.cos(theta);
                    double y = amplitude*Math.exp(-0.1*t) * Math.sin(t) + 1.5;
                    double z = t*Math.sin(theta);

                    loc.add(x, y, z);
                    loc.getWorld().spawnParticle(p, loc, count);
                    loc.subtract(x, y, z);
                }
                //check if t is greater than x and cancel
                if(t > duration)
                    cancel();
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    public void createDampeningRadialWaves(Location loc, BlockData data, int count, int thetaIncrease, float amplitude, int duration){
        //create runnable
        new BukkitRunnable(){
            double t = 0; //time variable (radius proportional)
            /*
            thetaIncrease: bigger number = more particles/circle (divisible by 8)
            amplitude: bigger the number = higher the particles
             */

            @Override
            public void run() {
                t = t + 0.1*Math.PI;
                for (double theta = 0; theta < 2*Math.PI; theta = theta + Math.PI/thetaIncrease){
                    double x = t*Math.cos(theta);
                    double y = amplitude*Math.exp(-0.1*t) * Math.sin(t) + 1.5;
                    double z = t*Math.sin(theta);

                    loc.add(x, y, z);
                    loc.getWorld().spawnParticle(Particle.BLOCK_DUST, loc, count, data);
                    loc.subtract(x, y, z);
                }
                //check if t is greater than x and cancel
                if(t > duration)
                    cancel();
            }
        }.runTaskTimer(plugin, 0, 1);
    }


    public void createDampeningRadialWaves(Location loc, int count, int thetaIncrease, float amplitude, int duration, int r, int g, int b){
        //create runnable
        new BukkitRunnable(){
            double t = 0; //time variable (radius proportional)
            /*
            thetaIncrease: bigger number = more particles/circle (divisible by 8)
            amplitude: bigger the number = higher the particles
             */

            @Override
            public void run() {
                t = t + 0.1*Math.PI;
                for (double theta = 0; theta < 2*Math.PI; theta = theta + Math.PI/thetaIncrease){
                    double x = t*Math.cos(theta);
                    double y = amplitude*Math.exp(-0.1*t) * Math.sin(t) + 1.5;
                    double z = t*Math.sin(theta);

                    loc.add(x, y, z);
                    loc.getWorld().spawnParticle(Particle.REDSTONE, loc, count, new Particle.DustOptions(Color.fromBGR(b, g, r), 1));
                    loc.subtract(x, y, z);
                }
                //check if t is greater than x and cancel
                if(t > duration)
                    cancel();
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    public void createExpandingCircle(Location loc, Particle p, int count, int thetaIncrease, int duration){
        //create runnable
        new BukkitRunnable(){
            double t = 0; //time variable (radius proportional)
            //thetaIncrease: bigger number = more particles/circle (divisible by 8)

            @Override
            public void run() {
                t = t + 0.1*Math.PI;
                for (double theta = 0; theta < 2*Math.PI; theta = theta + Math.PI/thetaIncrease){
                    double x = t*Math.cos(theta);
                    double z = t*Math.sin(theta);

                    loc.add(x, 0, z);
                    loc.getWorld().spawnParticle(p, loc, count);
                    loc.subtract(x, 0, z);
                }
                //check if t is greater than x and cancel
                if(t > duration)
                    cancel();
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    public void createExpandingCircle(Location loc, BlockData data, int count, int thetaIncrease, int duration){
        //create runnable
        new BukkitRunnable(){
            double t = 0; //time variable (radius proportional)
            //thetaIncrease: bigger number = more particles/circle (divisible by 8)

            @Override
            public void run() {
                t = t + 0.1*Math.PI;
                for (double theta = 0; theta < 2*Math.PI; theta = theta + Math.PI/thetaIncrease){
                    double x = t*Math.cos(theta);
                    double z = t*Math.sin(theta);

                    loc.add(x, 0, z);
                    loc.getWorld().spawnParticle(Particle.BLOCK_DUST, loc, count, data);
                    loc.subtract(x, 0, z);
                }
                //check if t is greater than x and cancel
                if(t > duration)
                    cancel();
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    public void createExpandingCircle(Location loc, int count, int thetaIncrease, int duration, int r, int g, int b){
        //create runnable
        new BukkitRunnable(){
            double t = 0; //time variable (radius proportional)
            //thetaIncrease: bigger number = more particles/circle (divisible by 8)

            @Override
            public void run() {
                t = t + 0.1*Math.PI;
                for (double theta = 0; theta < 2*Math.PI; theta = theta + Math.PI/thetaIncrease){
                    double x = t*Math.cos(theta);
                    double z = t*Math.sin(theta);

                    loc.add(x, 0, z);
                    loc.getWorld().spawnParticle(Particle.REDSTONE, loc, count, new Particle.DustOptions(Color.fromBGR(b, g, r), 1));
                    loc.subtract(x, 0, z);
                }
                //check if t is greater than x and cancel
                if(t > duration)
                    cancel();
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    public void createLaunchBeam(Location from, Location to, Particle p, int count, int duration){
        new BukkitRunnable(){
            double t = 0;
            Vector direction = to.toVector().subtract(from.toVector()).normalize(); // and magnitude... OH! YEAH

            @Override
            public void run() {
                t = t + 0.5;
                double x = direction.getX() * t;
                double y = direction.getY() * t;
                double z = direction.getZ() * t;
                from.add(x, y, z);
                from.getWorld().spawnParticle(p, from, count);
                from.subtract(x, y, z);

                if(t > duration){
                    this.cancel();
                }
            }

        }.runTaskTimer(plugin, 0, 0);
    }

    public void createLaunchBeam(Location from, Location to, int count, int duration, int r, int g, int b){
        new BukkitRunnable(){
            double t = 0;
            Vector direction = to.toVector().subtract(from.toVector()).normalize(); // and magnitude... OH! YEAH

            @Override
            public void run() {
                t = t + 0.5;
                double x = direction.getX() * t;
                double y = direction.getY() * t;
                double z = direction.getZ() * t;
                from.add(x, y, z);
                from.getWorld().spawnParticle(Particle.REDSTONE, from, count, new Particle.DustOptions(Color.fromBGR(b, g, r), 1));
                from.subtract(x, y, z);

                if(t > duration){
                    this.cancel();
                }
            }

        }.runTaskTimer(plugin, 0, 0);
    }


    public void createLaunchBeam(Location from, Location to, BlockData data, int count, int duration){
        new BukkitRunnable(){
            double t = 0;
            Vector direction = to.toVector().subtract(from.toVector()).normalize(); // and magnitude... OH! YEAH

            @Override
            public void run() {
                t = t + 0.5;
                double x = direction.getX() * t;
                double y = direction.getY() * t;
                double z = direction.getZ() * t;
                from.add(x, y, z);
                from.getWorld().spawnParticle(Particle.BLOCK_DUST, from, count, data );
                from.subtract(x, y, z);

                if(t > duration){
                    this.cancel();
                }
            }

        }.runTaskTimer(plugin, 0, 0);
    }

    public void createBeam(Location start, Location end, int r, int g, int b, int pointsPerLine, int particleCount) {
        double d = start.distance(end) / pointsPerLine;
        for (int i = 0; i < pointsPerLine; i++) {
            Location l = start.clone();
            Vector direction = end.toVector().subtract(start.toVector()).normalize();
            Vector v = direction.multiply(i * d);
            l.add(v.getX(), v.getY(), v.getZ());

            start.getWorld().spawnParticle(Particle.REDSTONE, l, particleCount, new Particle.DustOptions(Color.fromBGR(b, g, r), 1));

        }
    }
    public void createBeam(Location start, Location end, Particle p, int pointsPerLine, int particleCount) {
        double d = start.distance(end) / pointsPerLine;
        for (int i = 0; i < pointsPerLine; i++) {
            Location l = start.clone();
            Vector direction = end.toVector().subtract(start.toVector()).normalize();
            Vector v = direction.multiply(i * d);
            l.add(v.getX(), v.getY(), v.getZ());

            start.getWorld().spawnParticle(p, l, particleCount);

        }
    }

    public void createBeam(Location start, Location end, BlockData data, int pointsPerLine, int particleCount) {
        double d = start.distance(end) / pointsPerLine;
        for (int i = 0; i < pointsPerLine; i++) {
            Location l = start.clone();
            Vector direction = end.toVector().subtract(start.toVector()).normalize();
            Vector v = direction.multiply(i * d);
            l.add(v.getX(), v.getY(), v.getZ());

            start.getWorld().spawnParticle(Particle.BLOCK_DUST, l, particleCount, data);

        }
    }


    public void createSphere(Location bottom, double r, int red, int green, int blue, int count){
        for(double phi = 0; phi <= Math.PI; phi += Math.PI / 30) {
            double y = r * Math.cos(phi) + 1.5;
            for(double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 45) {
                double x = r * Math.cos(theta) * Math.sin(phi);
                double z = r * Math.sin(theta) * Math.sin(phi);

                bottom.add(x, y, z);
                bottom.getWorld().spawnParticle(Particle.REDSTONE, bottom, count, new Particle.DustOptions(Color.fromBGR(blue, green, red), 1));
                bottom.subtract(x, y, z);
            }
        }
    }

    public void createSphere(Location bottom, double r, Particle p, int count){
        for(double phi = 0; phi <= Math.PI; phi += Math.PI / 30) {
            double y = r * Math.cos(phi) + 1.5;
            for(double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 45) {
                double x = r * Math.cos(theta) * Math.sin(phi);
                double z = r * Math.sin(theta) * Math.sin(phi);

                bottom.add(x, y, z);
                bottom.getWorld().spawnParticle(p, bottom, count);
                bottom.subtract(x, y, z);
            }
        }
    }

    public void createSphere(Location bottom, double r, BlockData data, int count){
        for(double phi = 0; phi <= Math.PI; phi += Math.PI / 30) {
            double y = r * Math.cos(phi) + 1.5;
            for(double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 45) {
                double x = r * Math.cos(theta) * Math.sin(phi);
                double z = r * Math.sin(theta) * Math.sin(phi);

                bottom.add(x, y, z);
                bottom.getWorld().spawnParticle(Particle.BLOCK_DUST, bottom, count, data);
                bottom.subtract(x, y, z);
            }
        }
    }


}
