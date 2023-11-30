package api.config;

import services.addTimeEntryService;
import services.deleteTimeEntryService;
import services.timeEntryService;
import services.updateTimeEntryService;

public enum EntityConfiguration {

    TIMEENTRY {
        @Override
        public Class<?> getEntityService() {
            return timeEntryService.class;
        }
    },

    ADDTIMEENTRY {
        @Override
        public Class<?> getEntityService() {
            return addTimeEntryService.class;
        }
    },
    UPDATETIMEENTRY {
        @Override
        public Class<?> getEntityService() { return updateTimeEntryService.class;
        }
    },
    DELETETIMEENTRY {
        @Override
        public Class<?> getEntityService() { return deleteTimeEntryService.class;
        }
    };

    public abstract Class<?> getEntityService();
}



