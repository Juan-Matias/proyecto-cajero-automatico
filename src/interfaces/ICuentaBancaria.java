package modelo;

public interface ICuentaBancaria {
    void depositar(double monto) throws EntradaInvalidaException;
    void retirar(double monto) throws SaldoInsuficienteException, EntradaInvalidaException;
    double getSaldo();
    String getTitular();
    String getTipoCuenta();
}
