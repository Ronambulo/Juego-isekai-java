package com.isekai.entities.enemies.slime;

public enum SlimeColor {
    RED("Rojo") ,BLUE("Azul"),RAINBOW("Multicolor");

    private String color;

    private SlimeColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // Método para obtener un color aleatorio
    public static SlimeColor getRandomColor() {
        return SlimeColor.values()[(int) (Math.random() * SlimeColor.values().length)];
    }
}
