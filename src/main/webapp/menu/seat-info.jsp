<%@ page language="java" pageEncoding="UTF-8" %>
<style type="text/css">
#accordion .panel-heading {
	cursor: pointer;
}
#accordion .panel-body {
	padding:0px;
}
</style>

      <!-- start of sidebar -->
<div class="panel-group col-md-2" id="accordion" role="tablist" aria-multiselectable="true" >

  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="collapse-header-seat" data-toggle="collapse" data-parent="#accordion" href="#collapse-body-seat" aria-expanded="true" aria-controls="collapse-body-seat">
      <h4 class="panel-title">
	    <i class="glyphicon glyphicon-list"></i>
        工位管理
      </h4>
    </div>
    <div id="collapse-body-seat" class="panel-collapse collapse ${currentMenu == 'seat' ? 'in' : ''}" role="tabpanel" aria-labelledby="collapse-header-seat">
      <div class="panel-body">
        <ul class="nav nav-list">
		  <li><a href="${tenantPrefix}/seat/seat-info-list.do"><i class="glyphicon glyphicon-list"></i> 工位管理</a></li>
        </ul>
      </div>
    </div>
  </div>

		<footer id="m-footer" class="text-center">
		  <hr>
		  &copy;Devaeye
		</footer>

</div>
      <!-- end of sidebar -->

