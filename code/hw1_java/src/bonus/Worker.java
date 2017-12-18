package bonus;

import bonus.Resource;

public class Worker {
    String name;
    boolean active;

    public Worker (String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public synchronized void work (Resource commonResource, Worker otherWorker) {
        while (active) {	//wait for the resource to become available.
            if (commonResource.owner != this) {
                try {
                    wait(10);
                } catch (InterruptedException e) {
                   //ignore
                }
                continue;
            }
            
            if (otherWorker.active) {	//If other worker is also active let it do it's work first
                System.out.println(name +  ": handover the resource to the worker " + otherWorker.name);
                commonResource.owner = otherWorker;
                continue;
            }

            //now use the commonResourc
            System.out.println(name + ": working on the common resource");
            active = false;
            commonResource.owner = otherWorker;
        }
    }
}
