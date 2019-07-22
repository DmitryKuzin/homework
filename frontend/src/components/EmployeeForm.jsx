import React, {Component} from 'react';
import PropTypes from 'prop-types';
import Form from 'antd/lib/form';
import Input from 'antd/lib/input';
import Button from 'antd/lib/button';
import {connect} from 'react-redux';
import {addEmployeeAsync} from '../actions';

class EmployeeForm extends Component {
  componentDidMount() {
    this.props.form.validateFields();
  }

  hasErrors = (fieldsError) => {
    return Object.keys(fieldsError).some(field => fieldsError[field]);
  };

  handleSubmit = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        this.props.addEmployee(values);
        console.log('Received values of form: ', values);
      }
    });
  };

  render() {
    const {getFieldDecorator, getFieldsError, getFieldError, isFieldTouched} = this.props.form;

    const usernameError = isFieldTouched('name') && getFieldError('name');
    const salaryError = isFieldTouched('summ') && getFieldError('summ');
    return (
      <Form className="create-form" layout="inline" onSubmit={this.handleSubmit}>
        <Form.Item validateStatus={usernameError ? 'error' : ''} help={usernameError || ''}>
          {getFieldDecorator('name', {
            rules: [{required: true, message: 'Please input name!'}],
          })(
            <Input
              placeholder="Name"
            />,
          )}
        </Form.Item>
        <Form.Item validateStatus={salaryError ? 'error' : ''} help={salaryError || ''}>
          {getFieldDecorator('summ', {
              rules: [
                {required: true, message: 'Please input Salary!'},
                {
                  pattern: "^[0-9]+$",
                  min: 0,
                  message: 'Please use positive numbers!'
                }
              ]
            },
          )(
            <Input
              placeholder="Salary"
            />,
          )}
        </Form.Item>
        <Form.Item>
          <Button type="primary" htmlType="submit" disabled={this.hasErrors(getFieldsError())}>
            Add
          </Button>
        </Form.Item>
      </Form>
    );
  }

}

const mapStateToProps = state => state;

const mapDispatchToProps = (dispatch) => {
  return {
    addEmployee: (props) => dispatch(
      addEmployeeAsync(props),
    )
  };
};

EmployeeForm.propTypes = {
  form: {
    getFieldDecorator: PropTypes.func,
    validateFields: PropTypes.func,
  }.isRequired,
  addEmployee: PropTypes.func,
};

export default connect(mapStateToProps, mapDispatchToProps)(Form.create({name: 'add-employee-form'})(EmployeeForm));
