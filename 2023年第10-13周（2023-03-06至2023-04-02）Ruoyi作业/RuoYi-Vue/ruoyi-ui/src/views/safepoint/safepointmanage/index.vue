<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="风险编码" prop="safepointName">
        <el-input
          v-model="queryParams.safepointName"
          placeholder="请输入风险编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="部门" prop="safepointDepartment">
        <el-input
          v-model="queryParams.safepointDepartment"
          placeholder="请输入部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类别" prop="safepointClassification">
        <el-input
          v-model="queryParams.safepointClassification"
          placeholder="请输入类别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目" prop="safepointProject">
        <el-input
          v-model="queryParams.safepointProject"
          placeholder="请输入项目"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项点" prop="safepointProjectpoint">
        <el-input
          v-model="queryParams.safepointProjectpoint"
          placeholder="请输入项点"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="风险等级
" prop="safepointRisklevel">
        <el-input
          v-model="queryParams.safepointRisklevel"
          placeholder="请输入风险等级
"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="危害程度" prop="safepointDangerlevel">
        <el-input
          v-model="queryParams.safepointDangerlevel"
          placeholder="请输入危害程度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['safepoint:safepointmanage:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['safepoint:safepointmanage:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['safepoint:safepointmanage:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['safepoint:safepointmanage:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="safepointmanageList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="safepointId" />
      <el-table-column label="风险编码" align="center" prop="safepointName" />
      <el-table-column label="部门" align="center" prop="safepointDepartment" />
      <el-table-column label="类别" align="center" prop="safepointClassification" />
      <el-table-column label="项目" align="center" prop="safepointProject" />
      <el-table-column label="项点" align="center" prop="safepointProjectpoint" />
      <el-table-column label="风险等级
" align="center" prop="safepointRisklevel" />
      <el-table-column label="危害程度" align="center" prop="safepointDangerlevel" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['safepoint:safepointmanage:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['safepoint:safepointmanage:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改安全项点记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="风险编码" prop="safepointName">
          <el-input v-model="form.safepointName" placeholder="请输入风险编码" />
        </el-form-item>
        <el-form-item label="部门" prop="safepointDepartment">
          <el-input v-model="form.safepointDepartment" placeholder="请输入部门" />
        </el-form-item>
        <el-form-item label="类别" prop="safepointClassification">
          <el-input v-model="form.safepointClassification" placeholder="请输入类别" />
        </el-form-item>
        <el-form-item label="项目" prop="safepointProject">
          <el-input v-model="form.safepointProject" placeholder="请输入项目" />
        </el-form-item>
        <el-form-item label="项点" prop="safepointProjectpoint">
          <el-input v-model="form.safepointProjectpoint" placeholder="请输入项点" />
        </el-form-item>
        <el-form-item label="风险等级" prop="safepointRisklevel">
          <el-input v-model="form.safepointRisklevel" placeholder="请输入风险等级" />
        </el-form-item>
        <el-form-item label="危害程度" prop="safepointDangerlevel">
          <el-input v-model="form.safepointDangerlevel" placeholder="请输入危害程度" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listSafepointmanage, getSafepointmanage, delSafepointmanage, addSafepointmanage, updateSafepointmanage } from "@/api/safepoint/safepointmanage";

export default {
  name: "Safepointmanage",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 安全项点记录表格数据
      safepointmanageList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        safepointName: null,
        safepointDepartment: null,
        safepointClassification: null,
        safepointProject: null,
        safepointProjectpoint: null,
        safepointRisklevel: null,
        safepointDangerlevel: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        safepointName: [
          { required: true, message: "风险编码不能为空", trigger: "blur" }
        ],
        safepointDepartment: [
          { required: true, message: "部门不能为空", trigger: "blur" }
        ],
        safepointClassification: [
          { required: true, message: "类别不能为空", trigger: "blur" }
        ],
        safepointProject: [
          { required: true, message: "项目不能为空", trigger: "blur" }
        ],
        safepointProjectpoint: [
          { required: true, message: "项点不能为空", trigger: "blur" }
        ],
        safepointRisklevel: [
          { required: true, message: "风险等级不能为空", trigger: "blur" }
        ],
        safepointDangerlevel: [
          { required: true, message: "危害程度不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询安全项点记录列表 */
    getList() {
      this.loading = true;
      listSafepointmanage(this.queryParams).then(response => {
        this.safepointmanageList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        safepointId: null,
        safepointName: null,
        safepointDepartment: null,
        safepointClassification: null,
        safepointProject: null,
        safepointProjectpoint: null,
        safepointRisklevel: null,
        safepointDangerlevel: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.safepointId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加安全项点记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const safepointId = row.safepointId || this.ids
      getSafepointmanage(safepointId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改安全项点记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.safepointId != null) {
            updateSafepointmanage(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSafepointmanage(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const safepointIds = row.safepointId || this.ids;
      this.$modal.confirm('是否确认删除安全项点记录编号为"' + safepointIds + '"的数据项？').then(function() {
        return delSafepointmanage(safepointIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('safepoint/safepointmanage/export', {
        ...this.queryParams
      }, `safepointmanage_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
