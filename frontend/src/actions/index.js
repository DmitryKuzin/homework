import axios from 'axios';
import notification from 'antd/lib/notification';

const baseUrl = 'http://localhost:8080/employee';
const allEmployeesUrl = baseUrl + '/all';

export const FETCH_EMPLOYEES = 'FETCH_EMPLOYEES';
export const ERROR_FETCHING = 'ERROR_FETCHING';
export const REQUEST_EMPLOYEE = 'REQUEST_EMPLOYEE';
export const GET_EMPLOYEE = 'GET_EMPLOYEE';

export const fetchEmplyeesAsync = () => {
  return dispatch => {
    axios({
      method: 'get',
      url: allEmployeesUrl,
    })
      .then((response) => {
        dispatch(fetchEmployees(response.data));
      })
      .catch(error => {
        dispatch(errorFetching(error));
        console.err(error);
      });
  };
};

export const addEmployeeAsync = props => {
  return dispatch => {
    axios({
      method: 'post',
      url: baseUrl,
      data: {
        name: props.name,
        salary: {
          summ: props.summ,
        }
      },
    })
      .then(() => {
        successNotification('Added employee');
        dispatch(fetchEmplyeesAsync());
      })
      .catch(error => {
        dispatch(errorFetching(error));
        errorNotification(error, 'Employee Adding Error');
      });
  };
};

export const editSalaryAsync = (employeeID, summ) => {
  return dispatch => {
    axios({
      method: 'put',
      url: baseUrl + `/${employeeID}` + '/salary',
      data: {
        summ,
      },
    })
      .then(() => {
        successNotification(`Edited Salary for Employee id -  ${employeeID}`);
        dispatch(fetchEmplyeesAsync());
      })
      .catch(error => {
        dispatch(errorFetching(error));
        errorNotification(error, `Editing Salary fro User with id - ${employeeID} Eror!`);
      });
  };
};

export const deleteEmployeesAsync = () => {
  return dispatch => {
    axios({
      method: 'delete',
      url: allEmployeesUrl,
    })
      .then(() => {
        successNotification('Deleted all employees');
        dispatch(fetchEmplyeesAsync());
      })
      .catch(error => {
        dispatch(errorFetching(error));
        errorNotification(error, 'Deleting All Error');
      });
  };
};


function fetchEmployees(employees) {
  return {
    type: FETCH_EMPLOYEES,
    employees,
  };
}

function errorFetching(error) {
  return {
    type: ERROR_FETCHING,
    error,
  };
}

function errorNotification(error, message) {
  notification.error({
    message,
    description: error.message,
  });
}

function successNotification(description) {
  notification.success({
    message: 'Success',
    description,
  });
}


