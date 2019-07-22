import React, {Component, Fragment} from 'react';
import PropTypes from 'prop-types';
import Button from 'antd/lib/button';
import Table from 'antd/lib/table';
import Input from 'antd/lib/input';
import Form from 'antd/lib/form';

class EditableTable extends Component {
  state = {
    editing: false,
    editingRowId: -1,
  };

  getColumns = () => {
    const {form} = this.props;
    const {editing, editingRowId} = this.state;
    return [
      {
        title: 'name',
        dataIndex: 'name',
        width: '40%',
      },
      {
        title: 'salary',
        dataIndex: 'salary.summ',
        width: '40%',
        render: (summ, record) => {
          return (
            (editing && record.id === editingRowId) ?
              (<Form.Item style={{margin: 0}}>
                {form.getFieldDecorator('summ' + record.id, {
                  rules: [{required: true, message: 'Please input Salary!'}, {
                    pattern: "^[0-9]+$",
                    min: 0,
                    message: 'Please use positive numbers!'
                  }],
                  initialValue: summ.toString(),
                })(<Input/>)}
              </Form.Item>)
              : <span>{summ}</span>
          );
        },
      },
      {
        title: 'operation',
        dataIndex: 'operation',
        render: (_, record) => (
          (editing && record.id === editingRowId) ?
            (<Fragment>
              <Button onClick={() => this.save(record.id)}>save</Button>
              <Button onClick={() => this.closeEditMode(record.id)}>cancel</Button>
            </Fragment>)
            : <Button onClick={() => this.openEditMode(record.id)}>edit</Button>
        )
      },
    ];
  };

  openEditMode = (employeeId) => {
    this.setState({editing: true, editingRowId: employeeId})
  };

  closeEditMode = () => {
    this.setState({editing: false, editingRowId: -1})
  };

  save = (employeeId) => {
    const {form, editSalary} = this.props;
    form.validateFields((error) => {
      if (error) {
        return;
      }
      const editingSumm = form.getFieldValue('summ' + employeeId);
      editSalary(employeeId, +editingSumm)
    });
    this.closeEditMode(employeeId);
  };

  render() {
    const {employees} = this.props;
    const columns = this.getColumns();
    return (
      <Table
        bordered
        dataSource={employees}
        columns={columns}
        pagination={false}
      />
    );
  }
}

EditableTable.propTypes = {
  employees: PropTypes.object,
  form: {
    getFieldDecorator: PropTypes.func,
    validateFields: PropTypes.func,
  }.isRequired,
};

export default Form.create()(EditableTable);
