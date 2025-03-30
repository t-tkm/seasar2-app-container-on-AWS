resource "aws_cloudwatch_log_group" "demo" {
  name = "awslogs-${var.app_name}-log"
}
