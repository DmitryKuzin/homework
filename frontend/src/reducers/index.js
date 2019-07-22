import {
    FETCH_EMPLOYEES,
    GET_EMPLOYEE,
    REQUEST_EMPLOYEE,
    ERROR_FETCHING,
} from '../actions';

const reducers = (
    state = {
        isLoading: false,
        employees: [],
        error: false,
    },
    action
) => {
  console.log(action);
    switch (action.type) {
        case FETCH_EMPLOYEES:
            return {
                ...state,
                employees: action.employees,
            };
        case ERROR_FETCHING:
            return {
                ...state,
                isLoading: false,
                error: true,
            };
        case REQUEST_EMPLOYEE:
            return { ...state, isLoading: true };
        case GET_EMPLOYEE:
            return {
                ...state,
                isLoading: false,
            };
        default:
            return state;
    }
};

export default reducers;
