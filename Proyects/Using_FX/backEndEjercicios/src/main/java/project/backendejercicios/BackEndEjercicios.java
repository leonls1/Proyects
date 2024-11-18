/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package project.backendejercicios;

/**
 *
 * @author leon
 */
public class BackEndEjercicios {

    public static void main(String[] args) {
        int a =20, b=6;
        System.out.println((((a/b)*4))%7);


        
    }
    
    public static int [] generar( int v[] )
    {        
        int ac = 0;
        for(int i = 0; i < v.length; i++) ac += v[i]; //acumula en ac los valores del vector
        
        float p = ac / v.length; //promedio de v[]

        int c = 0;  
        for(int i = 0; i < v.length; i++)
        {
            if(v[i] >= p) c++; //cuantos valores supreann al promedio
        }
        
        int mp[] = new int[c], idx = 0;
        for(int i = 0; i < v.length; i++)
        {
            if(v[i] >= p)
            {
                mp[idx] = v[i];//en que indice estan esos valores que superan al promedio
                idx++;
            }
        }
        
        return mp; //devuelve los numero que superen el promedio de v
    }
}
