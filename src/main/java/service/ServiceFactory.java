package service;

public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    public synchronized static ServiceFactory getInstance() {

        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
            return serviceFactory;
        }

        return serviceFactory;
    }

    private ServiceFactory() {

    }

    public DispatcherService getDispatcherService() {
        return new DispatcherService();
    }

    public AccountService getAccountService() {
        return new AccountService();
    }

    public DriverService getDriverService() {
        return new DriverService();
    }

    public ClientService getClientService(){
        return new ClientService();
    }
}

