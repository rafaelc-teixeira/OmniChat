export interface ChatMessage {
    createdDate?: Date;
    message: string;
    sender: string;
    id?: string;
    channelId: number;
  }
  