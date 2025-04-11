package modelo;

public class CuentaBancaria implements modelo.ICuentaBancaria {
    protected String titular;
    protected String tipoCuenta;
    protected double saldo;

    public CuentaBancaria(String titular, String tipoCuenta, double saldo) {
        this.titular = titular;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public void depositar(double monto) throws EntradaInvalidaException {
        if (monto <= 0) {
            throw new EntradaInvalidaException("El monto a depositar debe ser mayor que cero.");
        }
        saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException, EntradaInvalidaException {
        if (monto <= 0) {
            throw new EntradaInvalidaException("El monto a retirar debe ser mayor que cero.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro.");
        }
        saldo -= monto;
    }

    public String getTitular() {
        return titular;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
}
