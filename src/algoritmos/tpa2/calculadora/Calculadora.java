package algoritmos.tpa2.calculadora;

import algoritmos.estructuras.pila.PilaE;

/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 19/03/12
 * Time: 10:19
 * To change this template use File | Settings | File Templates.
 */
public class Calculadora {
    private PilaE pilaOperadores;
    private String cuentaAux;
    private double resultado;

    public Calculadora() {
        pilaOperadores = new PilaE();
        cuentaAux = "";
    }

    private int analizarJerarquia(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    private void analizarClasificacion(char a) {
        if (pilaOperadores.esVacio()) {
            pilaOperadores.apilar(a);
        } else {
            while (!pilaOperadores.esVacio() && analizarJerarquia(a) <= analizarJerarquia((Character) pilaOperadores.verTope())) {
                cuentaAux = cuentaAux.concat("" + pilaOperadores.verTope());
                pilaOperadores.desapilar();
            }
            pilaOperadores.apilar(a);
        }
    }

    private double cuenta(String n) {
        for (int i = 0; i < n.length(); i++) {
            Character operacion = n.charAt(i);
            switch (operacion) {
                case ('*'):
                    Double operando1 = (Double.parseDouble("" + pilaOperadores.verTope()));
                    pilaOperadores.desapilar();
                    Double operando2 = (Double.parseDouble("" + pilaOperadores.verTope()));
                    pilaOperadores.desapilar();
                    pilaOperadores.apilar(operando1 * operando2);
                    break;
                case ('/'):
                    operando1 = (Double.parseDouble("" + pilaOperadores.verTope()));
                    pilaOperadores.desapilar();
                    operando2 = (Double.parseDouble("" + pilaOperadores.verTope()));
                    pilaOperadores.desapilar();
                    pilaOperadores.apilar(operando2 / operando1);

                    break;
                case ('+'):
                    operando1 = (Double.parseDouble("" + pilaOperadores.verTope()));
                    pilaOperadores.desapilar();
                    operando2 = (Double.parseDouble("" + pilaOperadores.verTope()));
                    pilaOperadores.desapilar();
                    pilaOperadores.apilar(operando1 + operando2);
                    break;
                case ('-'):
                    operando1 = (Double.parseDouble("" + pilaOperadores.verTope()));
                    pilaOperadores.desapilar();
                    operando2 = (Double.parseDouble("" + pilaOperadores.verTope()));
                    pilaOperadores.desapilar();
                    pilaOperadores.apilar(operando2 - operando1);
                    break;
                case ('^'):
                    operando1 = (Double.parseDouble("" + pilaOperadores.verTope()));
                    pilaOperadores.desapilar();
                    operando2 = (Double.parseDouble("" + pilaOperadores.verTope()));
                    pilaOperadores.desapilar();
                    pilaOperadores.apilar(Math.pow(operando2, operando1));
                    break;
                case ' ':
                    break;
                default:
                    pilaOperadores.apilar(operacion);
                    break;
            }
        }

        resultado = (Double.parseDouble("" + pilaOperadores.verTope()));
        pilaOperadores.desapilar();
        return resultado;
    }


    public String ordenarCuenta(String laCuenta) {
        cuentaAux = "";
        for (int i = 0; i < laCuenta.length(); i++) {
            switch (laCuenta.charAt(i)) {
                case ('*'):
                    analizarClasificacion('*');
                    break;
                case ('/'):
                    analizarClasificacion('/');
                    break;
                case ('+'):
                    analizarClasificacion('+');
                    break;
                case ('-'):
                    analizarClasificacion('-');
                    break;
                case ('^'):
                    analizarClasificacion('^');
                    break;
                case ' ':
                    break;
                default:
                    cuentaAux = cuentaAux + laCuenta.charAt(i);
                    break;
            }
        }

        while (!pilaOperadores.esVacio()) {
            cuentaAux = cuentaAux.concat("" + pilaOperadores.verTope());
            pilaOperadores.desapilar();
        }
        return cuentaAux;
    }

    public Double resultado(String n) {
        return cuenta(ordenarCuenta(n));
    }
}