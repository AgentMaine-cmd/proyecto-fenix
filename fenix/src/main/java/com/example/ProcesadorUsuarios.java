package com.example;

import java.util.List;
/**
 * Esta clase procesa listas de usuarios. Contiene 'code smells' intencionados.
 */
public class ProcesadorUsuarios {
       private static final int ROL_INVITADO = 2;
       private static final int ROL_ADMIN = 1;

    // Método con 'code smells': largo, números mágicos, malos nombres.
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

    private String procesadorInvitado(String invitados, String nombre) {
        invitados += nombre + ',';
        return invitados;
    }

    private String procesadorAdmin(String admins, String nombre) {
        admins += nombre + ",";
        return admins;
    }
}
