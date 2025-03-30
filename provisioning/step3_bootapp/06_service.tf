#####################################
# Service Setting
#####################################
resource "aws_ecs_service" "demo" {
  name            = "${var.app_name}-service"
  cluster         = aws_ecs_cluster.demo.id
  task_definition = aws_ecs_task_definition.demo.arn
  desired_count   = 3
  launch_type     = "FARGATE"

  load_balancer {
    target_group_arn = aws_alb_target_group.demo.id
    container_name   = "demo"
    container_port   = 8080
  }

  network_configuration {
    subnets = [
      "${data.aws_subnet.public_1.id}",
      "${data.aws_subnet.public_2.id}"
    ]

    security_groups = [
      "${data.aws_security_group.public.id}"
    ]
    assign_public_ip = "true"
  }

  depends_on = [
    aws_alb_listener.demo
  ]
}
