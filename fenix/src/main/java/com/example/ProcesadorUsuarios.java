package com.example;

import java.util.List;
/**
 * Esta clase procesa listas de usuarios. Contiene 'code smells' intencionados.
 */

public class ProcesadorUsuarios {
       private static final int ROL_INVITADO = 2;
       private static final int ROL_ADMIN = 1;

    // Método con 'code smells': largo, números mágicos, malos nombres.

    /**
     * Procesamos una lista de usuarios que separamos por roles y que luego devovlemos diferenciados entre admins y usuarios junto a sus nombres
     * 
     * @param dataList Array que contiene una lista de usuarios
     * 
     * @return devuelve una lista de usuarios diferenciados entre invitados y usuarios
     */
    public String procesarLista(List<String> dataList) {
        String admins = "";
        String invitados = "";

        for (String usuarios : dataList) {
            String[] parts = usuarios.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                // Número Mágico: 1 es Admin
                if (rol == ROL_ADMIN) {
                    admins = procesadorAdmin(admins, nombre);
                }
                // Número Mágico: 2 es Invitado
                else if (rol == ROL_INVITADO) {
                    invitados = procesadorInvitado(invitados, nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }
    /** 
     * Añadimos el nombre de un usuario a la cadena 
     * 
     * @param invitados cadena donde añadimos los usuarios con el rol de invitado
     * @param nombre nombre de los usuarios con el rol de invitados
     * @return devuelve una cadena con el nombre del nuevo usuario invitado
     */
    private String procesadorInvitado(String invitados, String nombre) {
        invitados += nombre + ',';
        return invitados;
    }
    /**
     * añadimos el nombre de un usuario a la cadena
     * 
     * @param admins cadena donde añadimos los usuarios con el rol de admins
     * @param nombre nombre de los usuarios con el rol de admins
     * @return devuelve una cadena con el nombre del nuevo usuario admin
     */
    private String procesadorAdmin(String admins, String nombre) {
        admins += nombre + ",";
        return admins;
    }
    //prueba 1 de commit con automatizacion
    //prueba 2 de commit con automatizacion
}
